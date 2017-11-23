package com.mwm.env.manager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.mwm.commons.commonConst.Const;
import com.mwm.commons.controller.BaseController;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.commons.util.ValidateUtil;
import com.mwm.env.envConst.CommonUtil;
import com.mwm.env.mybatis.modal.AccountInfo;
import com.mwm.env.mybatis.modal.IndexInfo;
import com.mwm.env.service.IAccountService;
import com.mwm.env.util.EnvUtils;
import com.mwm.env.util.UserUtil;

/**
 * 权限管理模块
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("manager/Priv")
public class PrivController extends BaseController implements IAnonymousRequest{

	/***********************************运营人员******************************/
	
	@Autowired
	private IAccountService accountService;
	
	/**
	 * @api {GET} manager/staff 运营人员-获取
	 * @apiName getStaff
	 * @apiGroup mgrPriv
	 *
	 * @apiParam {String} accountname 账户名(可选)
	 * @apiparam {int} page 页码(可选)
	 * @apiparam {int} pageSize 每页显示的内容数(可选)
	 *
	 * @apiSuccess {int} accountid 账户id
	 * @apiSuccess {String} accountname 账户名
	 * @apiSuccess {String} accountuser 使用者姓名
	 * @apiSuccess {String} phone 绑定的手机
	 * @apiSuccess {String} crantid 权限级别
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/staff")
	public void getStaff() {
		//包装参数
		String accountname = reqString("accountname");
		
		Map params = new HashMap<>();
		params.put("accountname", accountname);
		
		//分页
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> accountInfoList = accountService.queryAccountInfo(params, page);
		page = new PageInfo<>(accountInfoList);
		
		this.setSuccessJsonFromData(CommonUtil.toLowerCaseForList(accountInfoList));
	}
	
	/**
	 * @api {POST} manager/staff 运营人员-新增
	 * @apiName addStaff
	 * @apiGroup mgrPriv
	 *
	 * @apiParam {String} accountname 账户名
	 * @apiParam {String} accountuser 使用者姓名
	 * @apiParam {String} phone 绑定的手机
	 * @apiParam {String} accountpwd 登陆密码
	 * @apiParam {String} grantid 权限级别
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/staff")
	public void addStaff() {
		//接收参数
		String accountname = reqString("accountnmae");
		String accountuser = reqString("accountuser");
		String phone = reqString("phone");
		String accountpwd = reqString("accountpwd");
		String accountpasswd = DigestUtils.md5Hex(accountpwd);
		String grantid = reqString("grantid");
		
		//执行操作
		AccountInfo account = new AccountInfo();
		account.setAccountname(accountname);
		account.setAccountuser(accountuser);
		account.setPhone(phone);
		account.setAccountpwd(accountpasswd);
		account.setGrantid(Byte.parseByte(grantid));
		account.setState(Const.STATE_NORMAL);
		account.setModifydate(new Date().getTime());
		accountService.addOrEditAccountInfo(account);
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} manager/staff/:id 运营人员-编辑
	 * @apiName editStaff
	 * @apiGroup mgrPriv
	 *
	 * @apiParam {String} accountname 账户名
	 * @apiParam {String} accountuser 使用者姓名
	 * @apiParam {String} phone 绑定的手机
	 * @apiParam {String} accountpwd 登陆密码
	 * @apiParam {String} grantid 权限级别
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/staff/{id}")
	public void editStaff(@PathVariable("id") int id) {
		//接收参数
		String accountname = reqString("accountnmae");
		String accountuser = reqString("accountuser");
		String phone = reqString("phone");
		String accountpwd = reqString("accountpwd");
		String grantid = reqString("grantid");
		
		//执行操作
		AccountInfo account = new AccountInfo();
		account.setAccountid(id);
		account.setAccountname(accountname);
		account.setAccountuser(accountuser);
		account.setPhone(phone);
		account.setAccountpwd(accountpwd);
		account.setGrantid(Byte.parseByte(grantid));
		account.setModifydate(new Date().getTime());
		accountService.addOrEditAccountInfo(account);
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {DELETE} manager/staff/:id 运营人员-删除
	 * @apiName delStaff
	 * @apiGroup mgrPriv
	 *
	 * @apiParam {String} accountname 账户名
	 * @apiParam {String} accountuser 使用者姓名
	 * @apiParam {String} phone 绑定的手机
	 * @apiParam {String} accountpwd 登陆密码
	 * @apiParam {String} crantid 权限级别
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/staff/{id}")
	public void delStaff(@PathVariable("id") int id) {
		accountService.delAccountInfo(id);
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} manager/staff/:id/password 运营人员-重设密码
	 * @apiName changeStaffPwd
	 * @apiGroup mgrPriv
	 *
	 * @apiParam {String} oldpwd 旧密码
	 * @apiParam {String} newpwd 新密码
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/staff/{id}")
	public void changeStaffPwd(@PathVariable("id") int id) {
		//接收参数
		String oldpwd = reqString("oldpwd");
		String newpwd = reqString("newpwd");
		String newpasswd = DigestUtils.md5Hex(newpwd);
		
		//校验参数
		AccountInfo accountInfo = accountService.getAccountInfoById(id);
		Preconditions.checkArgument(!oldpwd.equals(accountInfo.getAccountpwd()), "旧密码错误");
		Preconditions.checkArgument(!oldpwd.equals(oldpwd), "新旧密码不可相同");
		
		//执行操作
		AccountInfo account = new AccountInfo();
		account.setAccountid(id);
		account.setAccountpwd(newpasswd);
		account.setModifydate(new Date().getTime());
		accountService.addOrEditAccountInfo(account);
		
		this.setSuccessJsonFromData();
	}
}
