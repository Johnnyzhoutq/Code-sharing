package com.mwm.env.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mwm.env.mybatis.modal.MasterOrderInfo;

public interface ICartService {
	
	/**
	 *  获取需求方购物车
	 * @param demanderId
	 * @return
	 */
	MasterOrderInfo getMasterCart(int demanderId);

	/**
	 * 购物车新增商品
	 * @param goods
	 * @param dwelltimes
	 */
	void addCartGoods(int demanderId,int goods, String dwelltimes);

	/**
	 * 获取购物车商品信息
	 * @param params
	 * @param page
	 * @return
	 */
	List<Map> getSlaveOrderForCart(Map params, PageInfo page);

}
