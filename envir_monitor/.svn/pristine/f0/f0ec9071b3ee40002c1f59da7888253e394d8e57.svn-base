package com.mwm.env.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mwm.env.mybatis.modal.DemandInfo;
import com.mwm.env.mybatis.modal.DemandLibInfo;

public interface IDemandService {

	/*****************************************需求集***********************************/
	/**
	 * 获取需求集列表
	 * @param params
	 * @param page
	 * @return
	 */
	List<Map> getDemandLib(Map params, PageInfo page);

	/**
	 * 新增或者修改需求集
	 * @param params
	 * @param page
	 * @return
	 */
	int addOrEditDemandLib(DemandLibInfo demandLibInfo);
	
	/**
	 * 根据ID获取需求集详情
	 * @param params
	 * @param page
	 * @return
	 */
	DemandLibInfo getDemandLibById(int demandLibId);
	
	/**
	 * 删除指标集
	 * @param params
	 * @param page
	 * @return
	 */
	void delDemandLib(int demandLibId,int userId);
	
	/*****************************************需求***********************************/
	
	/**
	 * 获取需求集
	 * @param params
	 * @param page
	 * @return
	 */
	List<Map> getDemandList(Map params, PageInfo page);

	/**
	 * 新增或者修改需求
	 * @param params
	 * @param page
	 * @return
	 */
	int addOrEditDemand(DemandInfo demandInfo);
	
	/**
	 * 根据ID获取需求详情
	 * @param params
	 * @param page
	 * @return
	 */
	DemandInfo getDemandById(int demandId);
	
	/**
	 * 删除指标
	 * @param params
	 * @param page
	 * @return
	 */
	void delDemand(int demandId,int demandLibId,int userId);
	
	/*****************************************业务***********************************/

}
