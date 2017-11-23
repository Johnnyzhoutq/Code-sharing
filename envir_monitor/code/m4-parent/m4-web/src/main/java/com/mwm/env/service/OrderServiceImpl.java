package com.mwm.env.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mwm.commons.commonConst.Const;
import com.mwm.env.dao.IOrderDao;
import com.mwm.env.envConst.EnvConst;
import com.mwm.env.mybatis.dao.MasterOrderInfoMapper;
import com.mwm.env.mybatis.dao.SlaveOrderInfoMapper;
import com.mwm.env.mybatis.modal.MasterOrderInfo;
import com.mwm.env.mybatis.modal.SlaveOrderInfo;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private MasterOrderInfoMapper masterOrderInfoMapper;
	@Autowired
	private SlaveOrderInfoMapper slaveOrderMapper;

	@Override
	public Map getMasterOrderList(Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Map> orders = orderDao.getMasterOrderList(params);
		page = new PageInfo<>(orders);
		
		//分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("page", page);
		
		//订单数据
		List<Map> returnOrders = new ArrayList<>();
		for(Map map : returnOrders){
			//查子订单数据
		}
		returnMap.put("orders", returnOrders);
		
		return returnMap;
	}

	@Override
	public long addOrEditMasterOrder(MasterOrderInfo masterOrder) {
		if(masterOrder.getMasterid() == null){
			masterOrder.setCreatedate((new Date()).getTime());
			masterOrderInfoMapper.insertSelective(masterOrder);
			return masterOrder.getMasterid();
		}else{
			return masterOrderInfoMapper.updateByPrimaryKeySelective(masterOrder);
		}
	}

	@Override
	public MasterOrderInfo getMasterOrderById(long masterId) {
		return masterOrderInfoMapper.selectByPrimaryKey(masterId);
	}

	@Override
	public void delMasterOrderById(long masterId) {
		MasterOrderInfo masterOrderInfo = new MasterOrderInfo();
		masterOrderInfo.setMasterid(masterId);
		masterOrderInfo.setState(Const.STATE_DEL);
		addOrEditMasterOrder(masterOrderInfo);
	}

	@Override
	public List<Map> getSlaveOrderForMasterOrder(long masterId, Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return getSlaveOrderForMasterOrderNoPage(masterId,params);
	}
	
	//不分页查子订单
	public List<Map> getSlaveOrderForMasterOrderNoPage(long masterId, Map params) {
		//封装数据
		params.put("masterid", masterId);
		return orderDao.getSlaveOrderForMasterOrder(params);
	}

	@Override
	public long addOrEditSlaveOrder(long masterId, SlaveOrderInfo salveOrder) {
		if(salveOrder.getSlaveid() == null){
			salveOrder.setMasterid(masterId);
			salveOrder.setCreatedate((new Date()).getTime());
			slaveOrderMapper.insertSelective(salveOrder);
			return salveOrder.getSlaveid();
		}else{
			return slaveOrderMapper.updateByPrimaryKeySelective(salveOrder);
		}
	}

	@Override
	public SlaveOrderInfo getSlaveOrderById(long slaveId) {
		return slaveOrderMapper.selectByPrimaryKey(slaveId);
	}

	@Override
	public void delSlaveOrderById(long slaveId) {
		SlaveOrderInfo slaveOrder = new SlaveOrderInfo();
		slaveOrder.setSlaveid(slaveId);
		slaveOrder.setOrderstate(EnvConst.ORDER_STATE_CANCAL);
		addOrEditSlaveOrder(slaveId,slaveOrder);
	}

}
