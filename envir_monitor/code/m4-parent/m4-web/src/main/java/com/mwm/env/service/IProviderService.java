package com.mwm.env.service;

import java.util.Map;

import com.mwm.env.mybatis.modal.MemberInfo;
import com.mwm.env.mybatis.modal.MemberShipInfo;
import com.mwm.env.mybatis.modal.ProvideInfo;

public interface IProviderService {
	
	/******************************会员信息************************/
	/**
	 * 新增或者修改会员等级
	 * @param memberInfo
	 * @return
	 */
	int addOrEditMemberInfo(MemberInfo memberInfo);
	
	/******************************会员等级************************/
	/**
	 * 根据Code查找会员等级信息
	 * @param code
	 * @return
	 */
	MemberShipInfo getMemberShipInfoByCode(String code);
	
	/******************************成为供应方************************/
	/**
	 * 获取供应方信息
	 * @param provideid
	 * @return
	 */
	Map getProviderInfo(Integer provideid);

	/**
	 * 新增供应方
	 * @param provider
	 */
	void addProviderInfo(ProvideInfo provider);

}
