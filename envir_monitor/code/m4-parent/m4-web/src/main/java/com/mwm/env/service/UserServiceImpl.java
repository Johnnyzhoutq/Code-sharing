package com.mwm.env.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.mwm.commons.cache.EhcacheCacheUtil;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.commons.util.ValidateUtil;
import com.mwm.commons.util.WebUtil;
import com.mwm.env.envConst.EnvConst;
import com.mwm.env.mybatis.dao.CompanyUserInfoMapper;
import com.mwm.env.mybatis.dao.PersonalUserInfoMapper;
import com.mwm.env.mybatis.dao.UserBankInfoMapper;
import com.mwm.env.mybatis.dao.UserInfoMapper;
import com.mwm.env.mybatis.modal.CompanyUserInfo;
import com.mwm.env.mybatis.modal.PersonalUserInfo;
import com.mwm.env.mybatis.modal.UserBankInfo;
import com.mwm.env.mybatis.modal.UserBankInfoExample;
import com.mwm.env.mybatis.modal.UserInfo;
import com.mwm.env.mybatis.modal.UserInfoExample;
import com.mwm.env.util.SendMailUtil;

import net.sf.ehcache.Ehcache;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private CompanyUserInfoMapper companyUserInfoMapper;
	@Autowired
	private PersonalUserInfoMapper personUserInfoMapper;
	@Autowired
	private UserBankInfoMapper userBankInfoMapper;

	@Override
	public List<Map> getUserList(Map params, PageInfo page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOrUpdateUser(UserInfo user) {
		if(user.getUserid() == null){
			userInfoMapper.insertSelective(user);
			return user.getUserid();
		}else{
			return userInfoMapper.updateByPrimaryKeySelective(user);
		}
	}

	@Override
	public UserInfo getUserById(int userId) {
		return userInfoMapper.selectByPrimaryKey(userId);
	}

	@Override
	public UserInfo getUserByMobile(String mobile) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andUserphoneEqualTo(mobile);
		List<UserInfo> users = userInfoMapper.selectByExample(example);
		return users.size() == 0 ? null : users.get(0);
	}

	@Override
	public UserInfo getUserByEmail(String mail) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andUseremailEqualTo(mail);
		List<UserInfo> users = userInfoMapper.selectByExample(example);
		return users.size() == 0 ? null : users.get(0);
	}

	@Override
	public UserInfo addUserByMobile(String userPhone) {
		
		UserInfo user = new UserInfo();
		user.setUserphone(userPhone);
		user.setCreatedate((new Date()).getTime());
		//user.set
		
		return null;
	}

	@Override
	public boolean checkEmailNotRepeat(String userEmail) {
		UserInfo user = getUserByEmail(userEmail);
		return user == null;
	}

	@Override
	public UserInfo reg(UserInfo nuser, CompanyUserInfo companyUser, PersonalUserInfo personalUser,UserBankInfo bankInfo,String baseUrl) {
		int userId = addOrUpdateUser(nuser);
		//区分企业用户和个人用户
		if(nuser.getUsertype().equals(EnvConst.USER_TYPE_COMPANY)){
			companyUser.setUserid(userId);
			companyUserInfoMapper.insertSelective(companyUser);
		}else{
			personalUser.setUserid(userId);
			personUserInfoMapper.insertSelective(personalUser);
		}
		//银行信息
		if(StringUtils.isNotEmpty(bankInfo.getBankaccount())){
			bankInfo.setUserid(userId);
			userBankInfoMapper.insertSelective(bankInfo);
		}
		
		//发送校验邮件
		String code = RandomStringUtils.random(32);
		String url = baseUrl + "/user/verifyReg/"+code;
		//把code写入缓存
		EhcacheCacheUtil.getInstance().saveObj(code, nuser.getUserid()+"");
		sendRegMail(nuser.getUseremail(),nuser.getUsername(),url);
		return nuser;
	}
	
	private static void sendRegMail(String email,String userName, String url) {
		//构建邮件html
		String htmlTemp = "<html><head></head><body><div style='background-color:#ECECEC;padding:35px'><table cellpadding='0' align='center' style='width:600px;margin:0 auto;text-align:left;position:relative;border-top-left-radius:5px;border-top-right-radius:5px;border-bottom-right-radius:5px;border-bottom-left-radius:5px;font-size:14px;font-family:微软雅黑,黑体;line-height:1.5;box-shadow:#999 0 0 5px;border-collapse:collapse;background-position:initial initial;background-repeat:initial initial;background:#fff'><tbody><tr><th valign='middle' style='height:25px;line-height:25px;padding:15px 35px;border-bottom-width:1px;border-bottom-style:solid;border-bottom-color:#C46200;background-color:#FEA138;border-top-left-radius:5px;border-top-right-radius:5px;border-bottom-right-radius:0;border-bottom-left-radius:0'><font face='微软雅黑' size='5' style='color:#fff'>"
				+ "环境数据平台</font></th></tr><tr><td><div style='padding:25px 35px 40px;background-color:#fff'><h2 style='margin:5px 0'><font color='#333333' style='line-height:20px'><font style='line-height:22px' size='4'>"
				+ "亲爱的 "+userName+"：</font></font></h2><p>"
				+ "感谢您加入环境数据平台！请点击以下链接完成注册 :"
				+ "<a href='"+url+"'>"+url+"</a></p>"
				+ "<p align='right'>环境数据平台</p><p align='right'>"+DateFormatUtils.format(new Date(), "yyyy-MM-dd")+"</p></div></td></tr></tbody></table></div></body></html>";
		
		//发送邮件
		SendMailUtil emailUtil = new SendMailUtil();
		try {
			emailUtil.senMail(email, "感谢您加入环境数据平台！", htmlTemp);
		} catch(Exception e) {
			throw new MwmRuntimeException("邮件发送失败,请稍后重试");
		}
	}

	@Override
	public UserInfo login(String account, String userPwd) {
		//1、区分邮箱还是手机
		UserInfo user = new UserInfo();
		if(account.contains("@")){ //邮箱
			Preconditions.checkArgument(ValidateUtil.Email(account),"邮箱格式错误");
			user = getUserByEmail(account);
		}else{
			Preconditions.checkArgument(ValidateUtil.Mobile(account),"手机号码格式错误");
			user = getUserByMobile(account);
		}
		
		//校验密码
		Preconditions.checkArgument(user != null,"用户不存在");
		String salt = user.getSalt();
		String password = DigestUtils.md5Hex(userPwd + salt);
		Preconditions.checkArgument(password.equals(user.getUserpwd()),"账号或密码错误");
		
		return user;
	}

	@Override
	public void changeMobile(UserInfo user, String newPhone) {
		UserInfo reUser = getUserByMobile(newPhone);
		Preconditions.checkArgument(reUser == null, "手机号码已被注册");
		reUser = new UserInfo();
		reUser.setUserid(user.getUserid());
		reUser.setUserphone(newPhone);
		reUser.setModifydate((new Date()).getTime());
		addOrUpdateUser(reUser);
	}

	@Override
	public void changeEmail(UserInfo user, String newEmail) {
		UserInfo reUser = getUserByEmail(newEmail);
		Preconditions.checkArgument(reUser == null, "邮箱地址已被注册");
		reUser = new UserInfo();
		reUser.setUserid(user.getUserid());
		reUser.setUseremail(newEmail);
		reUser.setModifydate((new Date()).getTime());
		addOrUpdateUser(reUser);
	}

	@Override
	public List<UserBankInfo> getBankInfo(UserInfo user) {
		UserBankInfoExample example = new UserBankInfoExample();
		example.createCriteria().andUseridEqualTo(user.getUserid());
		return userBankInfoMapper.selectByExample(example);
	}

	@Override
	public int addOrUpdateBankInfo(UserInfo user,UserBankInfo bankInfo) {
		
		if(bankInfo.getBankid() == null){
			userBankInfoMapper.insertSelective(bankInfo);
			return bankInfo.getBankid();
		}else{
			//校验账户是否存在
			Preconditions.checkArgument(validateUserBank(user.getUserid(),bankInfo.getBankid()),"用户信息错误");
			return userBankInfoMapper.updateByPrimaryKeySelective(bankInfo);
		}
	}

	@Override
	public void delBankInfo(UserInfo user,int id) {
		UserBankInfoExample bankInfoExample = new UserBankInfoExample();
		bankInfoExample.createCriteria().andUseridEqualTo(user.getUserid()).andBankidEqualTo(id);
		userBankInfoMapper.deleteByExample(bankInfoExample);
	}

	@Override
	public UserBankInfo getBankInfoById(int bankId) {
		return userBankInfoMapper.selectByPrimaryKey(bankId);
	}

	@Override
	public boolean validateUserBank(int userId, int bankId) {
		if(getBankInfoById(bankId).getUserid() == userId){
			return true;
		}
		return false;
	}

	@Override
	public void changePasswd(UserInfo user, String oldPwd, String newPwd) {
		user = getUserById(user.getUserid());
		//验证旧密码
		oldPwd = DigestUtils.md5Hex(oldPwd + user.getSalt());
		Preconditions.checkArgument(user.getUserpwd().equals(oldPwd),"旧密码错误");
		
		//设置新密码
		String salt = RandomStringUtils.randomNumeric(5);
		String password = DigestUtils.md5Hex(newPwd+salt);
		
		user = new UserInfo();
		user.setUserid(user.getUserid());
		user.setUserpwd(password);
		user.setModifydate((new Date()).getTime());
		addOrUpdateUser(user);
	}

	@Override
	public void completeReg(String userId) {
		UserInfo user = new UserInfo();
		user.setModifydate((new Date()).getTime());
		user.setAuditstatus(EnvConst.USER_AUDIT_STATUS_YES);
		user.setModifydate((new Date()).getTime());
		addOrUpdateUser(user);
	}
}
