package com.mwm.commons.service;

import java.util.List;

import com.mwm.commons.mybatis.modal.MwmCity;
import com.mwm.commons.mybatis.modal.MwmConfig;
public interface IMWMCommonsService {

	/**
	 * 根据key查询配置项
	 * @param key
	 * @return
	 */
	public MwmConfig getConfigByKey(String key);
	
	/**
	 * 保存配置项
	 * @param key
	 * @param value
	 * @param type
	 */
	public void insertOrUpdateConfig(String key,String value,int type);
	
	/**
	 * 根据id获取城市
	 */
	public MwmCity getCityById(int cityId);
	
	/**
	 * 根据id获取父级城市
	 */
	public MwmCity getParentCityById(int cityId);
	
	/**
	 * 根据parentId获取城市
	 */
	public List<MwmCity> getCitiesByParentId(int parentId);
	
	/**
	 * 根据城市名获取城市
	 */
	public MwmCity getCitiesByName(String name);
	
	/**
	 * 获取所有的省
	 */
	public List<MwmCity> getProvinces();
}
