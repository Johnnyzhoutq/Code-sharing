package com.mwm.env.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mwm.env.mybatis.modal.CompanyUserInfo;
import com.mwm.env.mybatis.modal.PersonalUserInfo;
import com.mwm.env.mybatis.modal.UserBankInfo;
import com.mwm.env.mybatis.modal.UserInfo;

public interface IUserService {
	
	/************************基础接口********************/
	
	/**
	 * 获取用户列表
	 */
	List<Map> getUserList(Map params,PageInfo page);
	
	/**
	 * 新增或者编辑用户
	 */
	int addOrUpdateUser(UserInfo user);
	
	/**
	 * 根据Id查找用户
	 * @param userId
	 * @return
	 */
	UserInfo getUserById(int userId);
	UserInfo getUserByMobile(String mobile);
	UserInfo getUserByEmail(String mail);

	/**
	 * 根据手机号预生成用户
	 * @param userPhone
	 * @return
	 */
	UserInfo addUserByMobile(String userPhone);

	/**
	 * 邮箱是否重复
	 * @param userEmail
	 * @return
	 */
	boolean checkEmailNotRepeat(String userEmail);

	/**
	 * 创建用户
	 * @param nuser
	 * @param companyUser
	 * @param personalUser
	 * @return
	 */
	UserInfo reg(UserInfo nuser, CompanyUserInfo companyUser, PersonalUserInfo personalUser,UserBankInfo bankInfo,String baseUrl);

	/**
	 * 登陆
	 * @param account
	 * @param userPwd
	 */
	UserInfo login(String account, String userPwd);

	/**
	 * 修改手机号码
	 * @param user
	 * @param newPhone
	 */
	void changeMobile(UserInfo user, String newPhone);

	/**
	 * 修改用户邮箱
	 * @param user
	 * @param newEmail
	 */
	void changeEmail(UserInfo user, String newEmail);
	
	
	
	

	/**
	 * 银行信息列表
	 * @param user
	 * @return
	 */
	List<UserBankInfo> getBankInfo(UserInfo user);
	
	/**
	 * 根据Id获取银行信息
	 * @param user
	 * @return
	 */
	UserBankInfo getBankInfoById(int bankId);
	
	/**
	 * 根据Id获取银行信息
	 * @param user
	 * @return
	 */
	boolean validateUserBank(int userId,int bankId);

	/**
	 * 新增或者修改银行账户信息
	 * @param bankInfo
	 */
	int addOrUpdateBankInfo(UserInfo user,UserBankInfo bankInfo);

	/**
	 * 删除银行账号信息
	 * @param id
	 */
	void delBankInfo(UserInfo user,int id);

	/**
	 * 修改密码
	 * @param user
	 * @param oldPwd
	 * @param newPwd
	 */
	void changePasswd(UserInfo user, String oldPwd, String newPwd);

	/**
	 * 完成注册
	 * @param userId
	 */
	void completeReg(String userId);

}
