package com.mwm.env.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mwm.env.mybatis.modal.MasterOrderInfo;
import com.mwm.env.mybatis.modal.SlaveOrderInfo;

public interface IOrderService {

	/*******************************主订单*******************************/
	
	/**
	 * 主订单列表
	 * @param params
	 * @param page
	 * @return
	 */
	public Map getMasterOrderList(Map params,PageInfo page);
	
	/**
	 * 新增或者编辑主订单
	 * @param params
	 * @param page
	 * @return
	 */
	public long addOrEditMasterOrder(MasterOrderInfo masterOrder);
	
	/**
	 * 根据Id获取主订单
	 * @param masterId
	 * @return
	 */
	public MasterOrderInfo getMasterOrderById(long masterId);
	
	/**
	 * 删除订单
	 * @param masterId
	 */
	public void delMasterOrderById(long masterId);
	
	/*******************************子订单*******************************/
	/**
	 * 获取主订单下面的子订单
	 * @param params
	 * @param page
	 * @return
	 */
	public List<Map> getSlaveOrderForMasterOrder(long masterId,Map params,PageInfo page);
	
	/**
	 * 新增或者编辑子订单
	 * @param params
	 * @param page
	 * @return
	 */
	public long addOrEditSlaveOrder(long masterId,SlaveOrderInfo salveOrder);
	
	/**
	 * 根据Id获取子订单
	 * @param masterId
	 * @return
	 */
	public SlaveOrderInfo getSlaveOrderById(long slaveId);
	
	/**
	 * 删除子订单
	 * @param masterId
	 */
	public void delSlaveOrderById(long slaveId);
}
