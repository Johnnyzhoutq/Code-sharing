package com.mwm.env.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mwm.env.mybatis.modal.AccountInfo;
import com.mwm.env.mybatis.modal.AddressInfo;

public interface IAccountService {

	/**
	 * 运营账号登陆
	 * @param account
	 * @param userPwd
	 * @return
	 */
	AccountInfo login(String account, String userPwd);
	
	/**
	 * 分页获取运营账号列表
	 * @param params
	 * @param page
	 * @return
	 */
	public List<Map> queryAccountInfo(Map params, PageInfo page);
	
	/**
	 * 分页获取运营账号列表
	 * @param params
	 * @param page
	 * @return
	 */
	public List<AccountInfo> getAccountInfo(Map params, PageInfo page);
	
	/**
	 * 运营账号信息
	 * @param accountId
	 * @return
	 */
	public AccountInfo getAccountInfoById(int accountId);
	
	/**
	 * 新增或编辑运营账号
	 * @param account
	 * @return
	 */
	public int addOrEditAccountInfo(AccountInfo account);
	
	/**
	 * 删除运营账号
	 * @param accountId
	 */
	public void delAccountInfo(int accountId);

}
