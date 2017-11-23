package com.mwm.env.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.crypto.Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Preconditions;
import com.mwm.commons.cache.EhcacheCacheUtil;
import com.mwm.commons.controller.BaseController;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.env.envConst.EnvConst;
import com.mwm.env.mybatis.modal.CompanyUserInfo;
import com.mwm.env.mybatis.modal.PersonalUserInfo;
import com.mwm.env.mybatis.modal.UserBankInfo;
import com.mwm.env.mybatis.modal.UserInfo;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.commons.util.IDCardUtil;
import com.mwm.commons.util.ValidateUtil;
import com.mwm.commons.util.WebUtil;
import com.mwm.env.service.IUserService;
import com.mwm.env.util.UserUtil;

@Controller
@RequestMapping("user")
public class UserController extends BaseController implements IAnonymousRequest{
	
	@Autowired
	public IUserService userService;
	
	/**
	 * @api {GET} /user 获取用户信息
	 * @apiName getUserInfo
	 * @apiGroup user
	 *
	 * @apiParam {String} userphone 手机号码
	 * @apiParam {String} verifynum 短信验证码
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void getUserInfo(){
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} /user 注册,生成新用户（验证手机）
	 * @apiName reg
	 * @apiGroup user
	 *
	 * @apiParam {String} userPhone 手机号码
	 * @apiParam {String} verifyNum 短信验证码
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public void reg(){
		//参数
		String userPhone = reqString("userphone");
		String verifyNum = reqString("verifynum");
		//校验
		Preconditions.checkArgument(StringUtils.isNotBlank(userPhone),"请输入手机号");
		Preconditions.checkArgument(ValidateUtil.Mobile(userPhone),"请输入正确的手机号");
		Preconditions.checkArgument(StringUtils.isNotBlank(verifyNum),"请输入短信验证码");
	
		//校验手机号码的正确性
		String regMobile = getRequest().getSession().getAttribute("reg_mobile").toString();
		String regVerifyCode = getRequest().getSession().getAttribute("reg_verifyCode").toString();
		
		Preconditions.checkArgument(userPhone.equals(regMobile),"短信验证码错误");
		Preconditions.checkArgument(verifyNum.equals(regVerifyCode),"短信验证码错误");
		getRequest().getSession().setAttribute("reg_verifyState", true);
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @throws ParseException 
	 * @api {PUT} /user 注册（完善用户信息）
	 * @apiName updateUser
	 * @apiGroup user
	 *
	 * @apiParam {int} regtype 注册类型（1为企业，2为个人）
	 * @apiParam {String} companyname 企业名称（类型为企业时填写）
	 * @apiParam {String} orgcode 组织机构代码（类型为企业时填写）
	 * @apiParam {String} name 真实姓名（类型为个人时填写）
	 * @apiParam {String} idnumber 身份证号码（类型为个人时填写）
	 * @apiParam {String} idfronturl 身份证正面图片（类型为个人时填写）
	 * @apiParam {String} idbackurl 身份证背面图片（类型为个人时填写）
	 * @apiParam {String} userpwd 密码
	 * @apiParam {String} useremail 邮箱
	 * @apiParam {String} bankaccount 银行账号
	 * @apiParam {String} banktype 银行类型
	 * @apiParam {String} banks 开户行
	 * @apiParam {String} beneficiary 收款方
	 * 
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public void updateUser() throws ParseException{
		Preconditions.checkArgument(getRequest().getSession().getAttribute("reg_verifyState") != null,"系统错误，请重试");
		boolean verifyState = (boolean) getRequest().getSession().getAttribute("reg_verifyState");
		Preconditions.checkArgument(verifyState,"请先校验手机号码");

		//1、校验用户是否有重复信息
		String regMobile = getRequest().getSession().getAttribute("reg_mobile").toString();
		UserInfo user = userService.getUserByMobile("regMobile");
		Preconditions.checkArgument(user == null,"该用户已注册");
		
		//校验参数
		int regType = reqInt("regtype", 0);
		String companyName = reqString("companyname");
		String orgCode = reqString("orgcode");
		String name = reqString("name");
		String IDNumber = reqString("idnumber");
		String IDFrontURL = reqString("idfronturl");
		String IDBackURL = reqString("idbackurl");
		String userPwd = reqString("userpwd");
		String userEmail = reqString("useremail");
		String bankAccount = reqString("bankaccount");
		String bankType = reqString("banktype");
		String banks = reqString("banks");
		String beneficiary = reqString("beneficiary");
		
		Preconditions.checkArgument(regType!=0,"请选择注册类型");
		Preconditions.checkArgument(StringUtils.isNotEmpty(userPwd),"请输入密码");
		Preconditions.checkArgument(StringUtils.isNotEmpty(userEmail),"请输入用户邮箱");
		Preconditions.checkArgument(ValidateUtil.Email(userEmail),"邮箱格式错误");
		Preconditions.checkArgument(userService.checkEmailNotRepeat(userEmail),"邮箱格式错误");
		
		if(regType == 1){ //企业用户
			Preconditions.checkArgument(StringUtils.isNotEmpty(orgCode),"请输入组织机构代码");
		}else if(regType == 2){	//个人用户
			Preconditions.checkArgument(StringUtils.isNotEmpty(name),"请输入真实姓名");
			Preconditions.checkArgument(StringUtils.isNotEmpty(IDNumber),"请输入身份证号码");
			String msg = IDCardUtil.validateDCard(IDNumber);
			Preconditions.checkArgument(StringUtils.isNotBlank(msg),msg);
			Preconditions.checkArgument(StringUtils.isNotEmpty(IDFrontURL),"请上传身份证图片");
			Preconditions.checkArgument(StringUtils.isNotEmpty(IDBackURL),"请上传身份证图片");
		}else{
			throw new MwmRuntimeException("用户类型错误");
		}
		
		//校验银行账户信息
		if(StringUtils.isNotEmpty(bankAccount)){
			Preconditions.checkArgument(StringUtils.isNotEmpty(bankType),"请选择银行类型");
			Preconditions.checkArgument(StringUtils.isNotEmpty(banks),"请输入开户行");
			Preconditions.checkArgument(StringUtils.isNotEmpty(beneficiary),"请输入收款方");
		}
		
		//3、执行业务逻辑,组装并生成用户
		String salt = RandomStringUtils.randomNumeric(5);
		String password = DigestUtils.md5Hex(userPwd+salt);
		UserInfo nuser = new UserInfo();
		nuser.setAuditstatus(EnvConst.USER_AUDIT_STATUS_NOT);
		nuser.setBlacklistflag(EnvConst.USER_BLACK_STATUS_NOT);
		nuser.setCreatedate((new Date()).getTime());
		nuser.setSalt(salt);
		nuser.setUseremail(userEmail);
		nuser.setUsername(userEmail);
		nuser.setUserphone(regMobile);
		nuser.setUserpwd(password);
		nuser.setUsertype(regType+"");
		
		//封装企业用户
		CompanyUserInfo companyUser = new CompanyUserInfo();
		companyUser.setCompanyname(companyName);
		companyUser.setCreatedate((new Date()).getTime());
		companyUser.setOrgcode(orgCode);
		
		//封装个人用户
		PersonalUserInfo personalUser = new PersonalUserInfo();
		personalUser.setCreatedate((new Date()).getTime());
		personalUser.setIdnumber(IDNumber);
		personalUser.setName(name);
		personalUser.setIdurl(IDFrontURL);
		personalUser.setIdbackurl(IDBackURL);
		
		//封住银行信息
		UserBankInfo bankInfo = new UserBankInfo();
		bankInfo.setAuditstatus(EnvConst.USER_AUDIT_STATUS_NOT);
		bankInfo.setBankaccount(bankAccount);
		bankInfo.setBanks(banks);
		bankInfo.setBanktype(bankType);
		bankInfo.setBeneficiary(beneficiary);
		bankInfo.setCreatedate((new Date()).getTime());
		
		//生成用户
		String url = WebUtil.getBasePath(getRequest());
		UserInfo cuser = userService.reg(nuser,companyUser,personalUser,bankInfo,url);
		
		//注册完毕
		getRequest().getSession().setAttribute("reg_verifyState",false);
		this.setSuccessJsonFromData(cuser);
	}
	
	/**
	 * @api {POST} /user/verifyReg/:code 注册（注册验证邮箱）
	 * @apiDescription 发送注册邮件的时候检验code
	 * @apiName verifyReg
	 * @apiGroup user
	 */
	@RequestMapping(method=RequestMethod.POST,value="verifyReg/{code}")
	public void verifyReg(@PathVariable("code")String code){
		Object userIdObj = EhcacheCacheUtil.getInstance().get(code);
		Preconditions.checkArgument(userIdObj!=null,"验证码失效，请重新发送邮件验证");
		String userId = userIdObj.toString();
		
		//完成注册
		userService.completeReg(userId);
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} /user/login 登陆
	 * @apiName loginin
	 * @apiGroup user
	 * 
	 * @apiParam {String} account 账号（手机号或者邮箱）
	 * @apiParam {String} userpwd 密码
	 * @apiParam {String} verifycode 验证码
	 * 
	 * @apiSuccess {int} role 角色（1、供应方2、需求方）
	 */
	@RequestMapping(method=RequestMethod.POST,value="login")
	public void login(){
		//1、取参数校验
		String account = reqString("account");
		String userPwd = reqString("userpwd");
		String verifyCode = reqString("verifycode");
		String sessionVerifyCode = (String) getRequest().getSession().getAttribute("rand");
		Preconditions.checkArgument(StringUtils.isNotEmpty(sessionVerifyCode),"验证码未生成");
		Preconditions.checkArgument(StringUtils.isNotEmpty(account),"请输入账号");
		Preconditions.checkArgument(StringUtils.isNotEmpty(userPwd),"请输入密码");
		Preconditions.checkArgument(StringUtils.isNotEmpty(verifyCode),"请输入验证码");
		Preconditions.checkArgument(sessionVerifyCode.toLowerCase().equals(verifyCode),"验证码错误");
		
		//执行登陆操作
		UserInfo user = userService.login(account,userPwd);
		
		//用户写入session
		getRequest().getSession().setAttribute("user",user);
		//查询是否是供应方还是需求方，写入session
		
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} /user/loginout 退出登陆
	 * @apiName loginOut
	 * @apiGroup user
	 */
	@RequestMapping(method=RequestMethod.POST,value="loginout")
	public void loginOut(){
		this.getRequest().getSession().removeAttribute("user");
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} /user/password 修改密码
	 * @apiName changePasswd
	 * @apiGroup user
	 *
	 * @apiParam {String} oldpwd 旧密码
	 * @apiParam {String} newpwd 新密码
	 * @apiParam {String} verifycode 验证码
	 */
	@RequestMapping(method=RequestMethod.PUT,value="password")
	public void changePasswd(){
		UserInfo user = UserUtil.getUser(getRequest());
		//1、获取参数
		String oldPwd = reqString("oldpwd");
		String newPwd = reqString("newpwd");
		String verifyCode = reqString("verifycode");
		
		String sessionVerifyCode = (String) getRequest().getSession().getAttribute("rand");
		Preconditions.checkArgument(StringUtils.isNotEmpty(sessionVerifyCode),"验证码未生成");
		Preconditions.checkArgument(StringUtils.isNotEmpty(oldPwd),"请输入旧密码");
		Preconditions.checkArgument(StringUtils.isNotEmpty(newPwd),"请输入新密码");
		Preconditions.checkArgument(StringUtils.isNotEmpty(verifyCode),"请输入验证码");
		Preconditions.checkArgument(sessionVerifyCode.toLowerCase().equals(verifyCode),"验证码错误");
		
		userService.changePasswd(user,oldPwd,newPwd);
		
		//退出登陆
		this.getRequest().getSession().removeAttribute("user");
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} /user/userPhone 修改手机号码
	 * @apiName userPhone
	 * @apiGroup user
	 *
	 * @apiParam {String} newphone 新手机号码
	 * @apiParam {String} verifycode 验证码
	 */
	@RequestMapping(method=RequestMethod.PUT,value="userPhone")
	public void userPhone(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		//1、获取参数并校验
		String newPhone = reqString("newphone");
		String verifyCode = reqString("verifycode");
		Preconditions.checkArgument(StringUtils.isNotEmpty(newPhone),"请输入新手机号码");
		Preconditions.checkArgument(StringUtils.isNotEmpty(verifyCode),"请输入手机验证码");
		
		String EditVerifyCode = (String) getRequest().getSession().getAttribute("edit_verifyCode");
		Preconditions.checkArgument(StringUtils.isNotEmpty(EditVerifyCode),"短信验证码为空");
		Preconditions.checkArgument(EditVerifyCode.equals(verifyCode),"手机验证码错误");
		
		//修改手机号码
		userService.changeMobile(user,newPhone);
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} /user/userEmail 修改邮箱
	 * @apiName userEmail
	 * @apiGroup user
	 *
	 * @apiParam {String} newemail 新邮箱
	 */
	@RequestMapping(method=RequestMethod.PUT,value="userEmail")
	public void userEmail(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		String newEmail = reqString("newemail");
		Preconditions.checkArgument(StringUtils.isNotEmpty(newEmail),"请输入新的邮箱地址");
		Preconditions.checkArgument(ValidateUtil.Email(newEmail),"邮箱格式错误");
		
		//修改邮箱
		userService.changeEmail(user,newEmail);
		
		this.setSuccessJsonFromData();
	}
	
	
	/**************************************银行信息************************************/
	
	/**
	 * @api {GET} /user/bankInfo 银行信息-获取（列表）
	 * @apiName getBankInfo
	 * @apiGroup user
	 * 
	 * @apiSuccess {String} bankaccount 银行账号
	 * @apiSuccess {String} banktype 银行类型
	 * @apiSuccess {String} banks 开户行
	 * @apiSuccess {String} beneficiary 收款方
	 */
	@RequestMapping(method=RequestMethod.GET,value="bankInfo")
	public void getBankInfo(){
		UserInfo user = UserUtil.getUser(getRequest());
		//获取信息
		List<UserBankInfo> bankInfos = userService.getBankInfo(user);
		this.setSuccessJsonFromData(bankInfos);
	}
	
	/**
	 * @api {POST} /user/bankInfo 银行信息-新增
	 * @apiName addBankInfo
	 * @apiGroup user
	 *
	 * @apiParam {String} bankaccount 银行账号
	 * @apiParam {String} banktype 银行类型
	 * @apiParam {String} banks 开户行
	 * @apiParam {String} beneficiary 收款方
	 */
	@RequestMapping(method=RequestMethod.POST,value="bankInfo")
	public void addBankInfo(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		String bankAccount = reqString("bankaccount");
		String bankType = reqString("banktype");
		String banks = reqString("banks");
		String beneficiary = reqString("beneficiary");
		
		//校验银行账户信息
		Preconditions.checkArgument(StringUtils.isNotEmpty(bankAccount),"请选择银行账号");
		Preconditions.checkArgument(StringUtils.isNotEmpty(bankType),"请选择银行类型");
		Preconditions.checkArgument(StringUtils.isNotEmpty(banks),"请输入开户行");
		Preconditions.checkArgument(StringUtils.isNotEmpty(beneficiary),"请输入收款方");
		
		//封住银行信息
		UserBankInfo bankInfo = new UserBankInfo();
		bankInfo.setUserid(user.getUserid());
		bankInfo.setBankaccount(bankAccount);
		bankInfo.setBanks(banks);
		bankInfo.setBanktype(bankType);
		bankInfo.setBeneficiary(beneficiary);
		bankInfo.setCreatedate((new Date()).getTime());
		
		//修改账号信息
		userService.addOrUpdateBankInfo(user,bankInfo);
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} /user/bankInfo/:id 银行信息-修改
	 * @apiName bankInfo
	 * @apiGroup user
	 *
	  * @apiParam {String} bankaccount 银行账号
	 * @apiParam {String} banktype 银行类型
	 * @apiParam {String} banks 开户行
	 * @apiParam {String} beneficiary 收款方
	 */
	@RequestMapping(method=RequestMethod.PUT,value="bankInfo/{id}")
	public void bankInfo(@PathVariable(value = "id") int id){
		UserInfo user = UserUtil.getUser(getRequest());
		
		String bankAccount = reqString("bankaccount");
		String bankType = reqString("banktype");
		String banks = reqString("banks");
		String beneficiary = reqString("beneficiary");
		
		//校验银行账户信息
		Preconditions.checkArgument(StringUtils.isNotEmpty(bankAccount),"请选择银行账号");
		Preconditions.checkArgument(StringUtils.isNotEmpty(bankType),"请选择银行类型");
		Preconditions.checkArgument(StringUtils.isNotEmpty(banks),"请输入开户行");
		Preconditions.checkArgument(StringUtils.isNotEmpty(beneficiary),"请输入收款方");
		
		//封住银行信息
		UserBankInfo bankInfo = new UserBankInfo();
		bankInfo.setBankid(id);
		bankInfo.setBankaccount(bankAccount);
		bankInfo.setBanks(banks);
		bankInfo.setBanktype(bankType);
		bankInfo.setBeneficiary(beneficiary);
		bankInfo.setModifydate((new Date()).getTime());
		
		//修改账号信息
		userService.addOrUpdateBankInfo(user,bankInfo);
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {DELETE} /user/bankInfo/:id 银行信息-删除
	 * @apiName delBankInfo
	 * @apiGroup user
	 */
	@RequestMapping(method=RequestMethod.DELETE,value="bankInfo/{id}")
	public void delBankInfo(@PathVariable(value = "id") int id){
		UserInfo user = UserUtil.getUser(getRequest());
		//修改账号信息
		userService.delBankInfo(user,id);
		this.setSuccessJsonFromData();
	}
}
