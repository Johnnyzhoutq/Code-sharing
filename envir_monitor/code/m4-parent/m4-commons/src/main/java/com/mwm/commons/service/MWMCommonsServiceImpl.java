package com.mwm.commons.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mwm.commons.mybatis.dao.MwmCityMapper;
import com.mwm.commons.mybatis.dao.MwmConfigMapper;
import com.mwm.commons.mybatis.modal.MwmCity;
import com.mwm.commons.mybatis.modal.MwmCityExample;
import com.mwm.commons.mybatis.modal.MwmConfig;
import com.mwm.commons.mybatis.modal.MwmConfigExample;

@Service
@Transactional(readOnly = false)
public class MWMCommonsServiceImpl implements IMWMCommonsService {
	
	@Autowired
	private MwmConfigMapper configMapper;
	@Autowired
	private MwmCityMapper cityMapper;

	@Override
	public MwmConfig getConfigByKey(String key){
		MwmConfigExample example = new MwmConfigExample();
		example.createCriteria().andKeywordEqualTo(key);
		List<MwmConfig> configList = configMapper.selectByExample(example);
		return configList.size() == 0 ? null : configList.get(0);
	}
	
	@Override
	public void insertOrUpdateConfig(String key, String value, int type) {
		MwmConfig config = getConfigByKey(key);
		//TODO 应该记录操作日志
		if(config == null){
			config = new MwmConfig();
			config.setCreateDt(new Date());
			config.setVersion(new Date());
			config.setKeyword(key);
			config.setValue(value);
			config.setType(type);
			configMapper.insertSelective(config);
		}else{
			config.setVersion(new Date());
			config.setValue(value);
			configMapper.updateByPrimaryKeySelective(config);
		}
	}

	@Override
	public MwmCity getCityById(int cityId) {
		return cityMapper.selectByPrimaryKey(cityId);
	}

	@Override
	public List<MwmCity> getCitiesByParentId(int parentId) {
		MwmCityExample example = new MwmCityExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		return cityMapper.selectByExample(example);
	}

	@Override
	public List<MwmCity> getProvinces() {
		return getCitiesByParentId(0);
	}

	@Override
	public MwmCity getCitiesByName(String name) {
		MwmCityExample example = new MwmCityExample();
		example.createCriteria().andNameLike("%"+name+"%");
		List<MwmCity> cities = cityMapper.selectByExample(example);
		if(cities.size() > 0){
			return cities.get(0);
		}else{
			return null;
		}
	}

	@Override
	public MwmCity getParentCityById(int cityId) {
		MwmCity city = getCityById(cityId);
		return getCityById(city.getParentId());
	}
}
