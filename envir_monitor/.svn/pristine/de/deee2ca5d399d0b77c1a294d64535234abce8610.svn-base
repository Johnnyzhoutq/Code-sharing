package com.mwm.env.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mwm.env.mybatis.modal.AddressInfo;

public interface IAddressService {

	/**
	 * 获取地址列表
	 * @param params
	 * @param page
	 * @return
	 */
	public List<AddressInfo> userAddress(Map params,PageInfo page);
	
	/**
	 * 根据ID获取地址
	 * @param addrId
	 * @return
	 */
	public AddressInfo getAddressById(int addrId);
	
	/**
	 * 新增或者修改地址
	 * @param address
	 * @return
	 */
	public int addOrEditAddress(AddressInfo address);
	
	/**
	 * 删除地址
	 * @param addrId
	 * @return
	 */
	public void delAddress(int addrId);
}
