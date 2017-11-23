package com.mwm.env.controller;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Preconditions;
import com.mwm.commons.commonConst.Const;
import com.mwm.commons.controller.BaseController;
import com.mwm.env.mybatis.modal.UserInfo;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.commons.util.SMSUtil;
import com.mwm.commons.util.ValidateUtil;
import com.mwm.env.service.IUserService;

@Controller
@RequestMapping("common")
public class CommonController extends BaseController implements IAnonymousRequest{
	
	@Autowired
	private IUserService userService;

	/**
	 * @api {POST} /common/sendSMS 发送短信验证码
	 * @apiName sendSMS
	 * @apiGroup common
	 *
	 * @apiParam {String} userphone 手机号码
	 * @apiParam {int} smstype 短信类型（1、注册短信验证码2、修改手机号码验证码）
	 */
	@RequestMapping(method=RequestMethod.POST,value="sendSMS")
	public void sendSMS(){
		//获取参数
		String userPhone = reqString("userphone");
		int smsType = reqInt("smstype", 1);
		Preconditions.checkArgument(StringUtils.isNotEmpty(userPhone),"请输入手机号");
		Preconditions.checkArgument(ValidateUtil.Mobile(userPhone),"请输入正确的手机号");
		
		//获取用户
		UserInfo user = userService.getUserByMobile(userPhone);
		
		String valifyCode = RandomStringUtils.randomNumeric(6);
		if(smsType == 1){ //注册校验码
			Preconditions.checkArgument(user == null ,"该手机号码已被注册");
			SMSUtil.sendSMS(userPhone,valifyCode,SMSUtil.TEMP_CODE_REG);
			getRequest().getSession().setAttribute("reg_mobile", userPhone);
			getRequest().getSession().setAttribute("reg_verifyCode", valifyCode);
			getRequest().getSession().setAttribute("reg_verifyState", false);
		}else{	//修改手机校验码
			Preconditions.checkArgument(user != null ,"该手机号码尚未注册");
			SMSUtil.sendSMS(userPhone,valifyCode,SMSUtil.TEMP_CODE_CHANGE_INFO);
			getRequest().getSession().setAttribute("edit_verifyCode", valifyCode);
		}
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} /common/sendEmail 发送邮件
	 * @apiName sendEmail
	 * @apiGroup common
	 *
	 * @apiParam {String} useremail 邮箱地址
	 * @apiParam {int} type 类型（1、注册验证邮件）
	 */
	@RequestMapping(method=RequestMethod.POST,value="sendEmail")
	public void sendEmail(){
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} /servlet/AuthImg 登陆验证码(直接放在img的src上)
	 * @apiName AuthImg
	 * @apiGroup common
	 */
	
	/**
	 * @api {POST} /servlet/uploadImg 上传图片
	 * @apiName uploadImg
	 * @apiGroup common
	 * 
	 * @apiSuccess {String} url 图片地址
	 */
	
	/**
	 * @api {POST} /servlet/uploadFile 上传文件
	 * @apiName uploadFile
	 * @apiGroup common
	 * 
	 * @apiSuccess {String} url 文件地址
	 */
}
