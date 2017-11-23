package com.mwm.env.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mwm.commons.commonConst.Const;
import com.mwm.env.dao.IDemandDao;
import com.mwm.env.mybatis.dao.DemandInfoMapper;
import com.mwm.env.mybatis.dao.DemandLibInfoMapper;
import com.mwm.env.mybatis.modal.DemandInfo;
import com.mwm.env.mybatis.modal.DemandInfoExample;
import com.mwm.env.mybatis.modal.DemandLibInfo;
import com.mwm.env.mybatis.modal.DemandLibInfoExample;

@Service
public class DemandServiceImpl implements IDemandService {
	
	@Autowired
	private IDemandDao demandDao;
	@Autowired
	private DemandLibInfoMapper demandLibInfoMapper;
	@Autowired
	private DemandInfoMapper demandInfoMapper;

	@Override
	public List<Map> getDemandLib(Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return demandDao.getDemandLib(params);
	}

	@Override
	public int addOrEditDemandLib(DemandLibInfo demandLibInfo) {
		if(demandLibInfo.getDemandlibid() == null){
			demandLibInfoMapper.insertSelective(demandLibInfo);
			return demandLibInfo.getDemandlibid();
		}else{
			return demandLibInfoMapper.updateByPrimaryKeySelective(demandLibInfo);
		}
	}

	@Override
	public DemandLibInfo getDemandLibById(int demandLibId) {
		return demandLibInfoMapper.selectByPrimaryKey(demandLibId);
	}

	@Override
	public void delDemandLib(int demandLibId,int userId) {
		DemandLibInfo info = new DemandLibInfo();
		info.setState(Const.STATE_DEL);
		
		DemandLibInfoExample example = new DemandLibInfoExample();
		example.createCriteria().andUseridEqualTo(userId).andStateEqualTo(Const.STATE_NORMAL).andDemandlibidEqualTo(demandLibId);
		
		demandLibInfoMapper.updateByExampleSelective(info, example);
	}

	@Override
	public List<Map> getDemandList(Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return demandDao.getDemandList(params);
	}

	@Override
	public int addOrEditDemand(DemandInfo demandInfo) {
		if(demandInfo.getDemandid() == null){
			demandInfoMapper.insertSelective(demandInfo);
			return demandInfo.getDemandid();
		}else{
			return demandInfoMapper.updateByPrimaryKeySelective(demandInfo);
		}
	}

	@Override
	public DemandInfo getDemandById(int demandId) {
		return demandInfoMapper.selectByPrimaryKey(demandId);
	}

	@Override
	public void delDemand(int demandId,int demandLibId,int userId) {
		DemandInfoExample example = new DemandInfoExample();
		example.createCriteria().andDemandidEqualTo(demandId).andDemandlibidEqualTo(demandLibId).andUseridEqualTo(userId);
		demandInfoMapper.deleteByExample(example);
	}

}
