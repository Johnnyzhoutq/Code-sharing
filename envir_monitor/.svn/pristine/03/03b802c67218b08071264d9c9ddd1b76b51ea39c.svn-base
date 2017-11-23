package com.mwm.env.manager.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Preconditions;
import com.mwm.commons.controller.BaseController;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.env.mybatis.modal.AccountInfo;
import com.mwm.env.mybatis.modal.UserInfo;
import com.mwm.env.service.IAccountService;

/**
 * 用户管理模块
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("manager/user")
public class UserController extends BaseController implements IAnonymousRequest{
	
	@Autowired
	private IAccountService accountService;

	/***********************************用户管理模块******************************/
	
	/**
	 * @api {POST} manager/user/login 登陆
	 * @apiName loginin
	 * @apiGroup mgrUser
	 * 
	 * @apiParam {String} account 账号
	 * @apiParam {String} userPwd 密码
	 * @apiParam {String} verifyCode 验证码
	 * 
	 */
	@RequestMapping(method=RequestMethod.POST,value="login")
	public void login(){
		//1、取参数校验
		String account = reqString("account");
		String userPwd = reqString("userPwd");
		String verifyCode = reqString("verifyCode");
		String sessionVerifyCode = (String) getRequest().getSession().getAttribute("rand");
		Preconditions.checkArgument(StringUtils.isNotEmpty(sessionVerifyCode),"验证码未生成");
		Preconditions.checkArgument(StringUtils.isNotEmpty(account),"请输入账号");
		Preconditions.checkArgument(StringUtils.isNotEmpty(userPwd),"请输入密码");
		Preconditions.checkArgument(StringUtils.isNotEmpty(verifyCode),"请输入验证码");
		Preconditions.checkArgument(sessionVerifyCode.toLowerCase().equals(verifyCode),"验证码错误");
		
		//执行登陆操作
		AccountInfo accountInfo = accountService.login(account,userPwd);
		
		//管理员写入session
		getRequest().getSession().setAttribute("account",accountInfo);
		
		//TODO 返回操作权限
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} manager/user/loginout 退出登陆
	 * @apiName loginOut
	 * @apiGroup mgrUser
	 */
	@RequestMapping(method=RequestMethod.POST,value="loginout")
	public void loginOut(){
		this.getRequest().getSession().removeAttribute("account");
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {GET} manager/user 用户信息-获取
	 * @apiName getUserInfo
	 * @apiGroup mgrUser
	 *
	 * @apiParam {String} keyword 搜索关键词(可选)
	 * @apiparam {int} usertype 用户类型(可选)
	 * @apiparam {int} isprovider 是否是供应方（0否1是）(可选)
	 * @apiparam {int} auditstatus 审核状态（0否1是）(可选)
	 * @apiparam {int} blacklistflag 标记用户黑名单(0正常1黑名单)(可选)
	 * @apiparam {String} blacklistreason 拉黑原因(可选)
	 * @apiparam {int} page 页码(可选)
	 * @apiparam {int} pageSize 每页显示的内容数(可选)
	 *
	 * @apiSuccess {int} userid 用户ID
	 * @apiSuccess {String} username 用户名
	 * @apiSuccess {String} userphone 用户手机号
	 * @apiSuccess {String} useremail 用户email
	 * @apiSuccess {String} usertype 用户类型
	 * @apiSuccess {String} auditstatus 审核状态
	 * @apiSuccess {String} auditdate 审核最后操作时间
	 * @apiSuccess {String} bankstatus 银行认证状态
	 * @apiSuccess {String} useremail 用户email
	 * @apiSuccess {String} createdate 创建时间
	 * @apiSuccess {String} lastlogindate 最后一次登陆时间
	 * @apiSuccess {String} blacklistflag 标记用户黑名单(0正常1黑名单)
	 * @apiSuccess {String} blacklistreason 拉黑原因
	 * @apiSuccess {String} blacklistdate 拉黑时间
	 */
	public void getUserInfo() {
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} manager/user/:id 用户信息-编辑
	 * @apiName editUserInfo
	 * @apiGroup mgrUser
	 * 
	 * @apiparam {String} auditstatus 审核状态(可选)
	 * @apiparam {String} bankstatus 银行认证状态(可选)
	 * @apiparam {String} blacklistflag 标记用户黑名单(0正常1黑名单)(可选)
	 * @apiparam {String} blacklistreason 拉黑原因(可选)
	 */
	public void editUserInfo() {
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {GET} manager/user/excel 用户信息-导出excel
	 * @apiName getUserInfoExcel
	 * @apiGroup mgrUser
	 * 
	 * @apiparam {int} blacklistflag 用户黑名单(0正常1黑名单)(可选)
	 * @apiparam {String} blacklistreason 拉黑原因(可选)
	 *
	 * @apiSuccess {String} accountname 账户名
	 * @apiSuccess {String} accountuser 使用者姓名
	 * @apiSuccess {String} phone 绑定的手机
	 * @apiSuccess {String} crantid 权限级别
	 */
	public void getUserInfoExcel() {
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {GET} manager/user/:id/excel 用户信息-导出excel
	 * @apiName getUserInfoExcelForUser
	 * @apiGroup mgrUser
	 *
	 * @apiSuccess {String} accountname 账户名
	 * @apiSuccess {String} accountuser 使用者姓名
	 * @apiSuccess {String} phone 绑定的手机
	 * @apiSuccess {String} crantid 权限级别
	 */
	public void getUserInfoExcelForUser() {
		this.setSuccessJsonFromData();
	}
	
	
	/***********************************供应方******************************/
	
	/**
	 * @api {PUT} manager/user/:id/bankinfo 供应方-银行信息
	 * @apiName getProviderBankInfo
	 * @apiGroup mgrUser
	 *
	 * @apiSuccess {String} bankaccount 银行账号
	 * @apiSuccess {String} banks 开户行
	 * @apiSuccess {String} beneficiary 收款方姓名
	 * @apiSuccess {String} remark 转账备注
	 */
	public void getProviderBankInfo() {
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} manager/user/:id/bankinfo 供应方-审核通过银行信息
	 * @apiName checkProviderBankInfo
	 * @apiGroup mgrUser
	 *
	 * @apiSuccess {int} pass 是否通过（0否1是）
	 * @apiSuccess {String} remark 审核备注
	 */
	public void checkProviderBankInfo() {
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} manager/user/:id/provider 供应方-供应方信息
	 * @apiName getProviderInfo
	 * @apiGroup mgrUser
	 *
	 * @apiSuccess {String} measurecerurl 计量认证证书
	 * @apiSuccess {String} detectioncapabilityurl 检测能力附表
	 */
	public void getProviderInfo() {
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} manager/user/:id/provider 供应方-供应方信息
	 * @apiName checkProviderInfo
	 * @apiGroup mgrUser
	 *
	 * @apiSuccess {int} pass 是否通过（0否1是）
	 * @apiSuccess {String} remark 审核备注
	 */
	public void checkProviderInfo() {
		this.setSuccessJsonFromData();
	}
	
	/***********************************用户日志******************************/
	
	/**
	 * @api {GET} manager/user/log 用户日志-获取
	 * @apiName getUserLog
	 * @apiGroup mgrUser
	 * 
	 * @apiparam {String} username 用户名(可选)
	 * @apiparam {String} useraction 用户行为(可选)
	 * @apiparam {bigint} timeframe 时间范围(可选)
	 *
	 * @apiSuccess {String} username 用户名
	 * @apiSuccess {String} useraction 用户行为
	 * @apiSuccess {String} createdate 创建时间
	 */
	public void getUserLog() {
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {GET} manager/user/log/excel 用户日志-导出excel
	 * @apiName exportUserLogExcel
	 * @apiGroup mgrUser
	 * 
	 * @apiparam {String} username 用户名(可选)
	 * @apiparam {String} useraction 用户行为(可选)
	 * @apiparam {bigint} timeframe 时间范围(可选)
	 *
	 * @apiSuccess {String} url 文件地址
	 */
	public void exportUserLogExcel() {
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {DELETE} manager/user/log 用户日志-删除所有
	 * @apiName delUserLogAll
	 * @apiGroup mgrUser
	 */
	public void delUserLogAll() {
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {DELETE} manager/user/log/:id 用户日志-删除
	 * @apiName delUserLog
	 * @apiGroup mgrUser
	 */
	public void delUserLog() {
		this.setSuccessJsonFromData();
	}
}
