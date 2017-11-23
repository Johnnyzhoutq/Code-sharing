package com.mwm.commons.util;

import java.util.Date;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mwm.commons.cache.CacheUtil;
import com.mwm.commons.exception.MwmRuntimeException;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumQueryRequest;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumQueryResponse;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 阿里大鱼短信发送
 * @author hery
 *
 */
public class SMSUtil {	public static ResourceBundle bundle = PropertyResourceBundle.getBundle("sms");
	//App名
	public final static String APP_NAME = "每日乐";
	public final static String SMS_URL = bundle.getString("SMS_URL");
	public final static String APP_KEY = bundle.getString("APP_KEY");
	public final static String APP_SECRET = bundle.getString("APP_SECRET");
	
	//模版编码
	public final static String TEMP_CODE_VALIDATE_IDENTITY = bundle.getString("TEMP_CODE_VALIDATE_IDENTITY");	//身份验证验证码
	public final static String TEMP_CODE_CONFIRM_LOGIN = bundle.getString("TEMP_CODE_CONFIRM_LOGIN");			//登录确认验证码
	public final static String TEMP_CODE_REG = bundle.getString("TEMP_CODE_REG");								//用户注册验证码
	public final static String TEMP_CODE_EXCEPTION_LOGIN = bundle.getString("TEMP_CODE_EXCEPTION_LOGIN");		//登录异常验证码
	public final static String TEMP_CODE_CONFIRM_ACVITIES = bundle.getString("TEMP_CODE_CONFIRM_ACVITIES");		//活动确认验证码
	public final static String TEMP_CODE_CHANGE_PASSWD = bundle.getString("TEMP_CODE_CHANGE_PASSWD");			//修改密码验证码
	public final static String TEMP_CODE_CHANGE_INFO = bundle.getString("TEMP_CODE_CHANGE_INFO");				//信息变更验证码
	public final static String TEMP_CODE_COMMON = bundle.getString("TEMP_CODE_COMMON");							//通用验证码
	public final static String TEMP_CODE_CHANGE_PAYPASSWD = bundle.getString("TEMP_CODE_CHANGE_PAYPASSWD");		//修改密码验证码
	
	/**
	 * 短信发送
	 * @param phone
	 * @param valifyCode
	 * @throws ApiException
	 */
	public static void sendSMS(String mobile, String valifyCode,String templateCode){
		TaobaoClient client = new DefaultTaobaoClient(SMS_URL, APP_KEY, APP_SECRET);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setSmsType("normal");
		req.setSmsFreeSignName(APP_NAME);
		req.setSmsParamString("{\"code\":\""+valifyCode+"\",\"product\":\""+APP_NAME+"\"}");
		req.setRecNum(mobile);
		req.setSmsTemplateCode(templateCode);
		AlibabaAliqinFcSmsNumSendResponse rsp = new AlibabaAliqinFcSmsNumSendResponse();
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			throw new MwmRuntimeException("短信发送异常，请稍后重试");
		}
		
		//将手机号码和验证码缓存起来
		//CacheUtil.getInstance().saveObj(templateCode+mobile, valifyCode);
		//CacheUtil.getInstance().saveObj(templateCode+mobile+"time", (new Date()).getTime()+"");
		
		//响应code
		if(!rsp.isSuccess()){
			//throw new MwmRuntimeException(rsp.getSubMsg());
			throw new MwmRuntimeException("短信发送过于频繁，请稍后重试");
		}
	}
	
	public static void sendSMS(String mobile, String templateCode){
		String valifyCode = RandomStringUtils.randomNumeric(6);
		sendSMS(mobile,valifyCode,templateCode);
	}
	
	/**
	 * 身份验证短信
	 * @param mobile
	 * @throws ApiException 
	 */
	public static void sendValidateIdentitySMS(String mobile) {
		sendSMS(mobile,TEMP_CODE_VALIDATE_IDENTITY);
	}
	
	/**
	 * 发送登陆确认短信
	 * @param mobile
	 * @throws ApiException 
	 */
	public static void sendLoginConfirmSMS(String mobile) {
		sendSMS(mobile,TEMP_CODE_CONFIRM_LOGIN);
	}
	
	/**
	 * 发送注册短信
	 * @param mobile
	 * @throws ApiException 
	 */
	public static void sendRegSMS(String mobile) {
		sendSMS(mobile,TEMP_CODE_REG);
	}
	
	/**
	 * 发送登陆异常短信
	 * @param mobile
	 * @throws ApiException 
	 */
	public static void sendLoginExceptionSMS(String mobile) {
		sendSMS(mobile,TEMP_CODE_EXCEPTION_LOGIN);
	}
	
	/**
	 * 发送活动确认短信
	 * @param mobile
	 * @throws ApiException 
	 */
	public static void sendConfirmActivitySMS(String mobile) {
		sendSMS(mobile,TEMP_CODE_CONFIRM_ACVITIES);
	}
	
	/**
	 * 发送密码修改短信
	 * @param mobile
	 * @throws ApiException 
	 */
	public static void sendChangePasswdSMS(String mobile) {
		sendSMS(mobile,TEMP_CODE_CHANGE_PASSWD);
	}
	
	/**
	 * 发送通用短信
	 * @param mobile
	 * @throws ApiException 
	 */
	public static void sendCommonSMS(String mobile) {
		sendSMS(mobile,TEMP_CODE_COMMON);
	}
	
	/**
	 * 发送修改信息短信
	 * @param mobile
	 * @throws ApiException 
	 */
	public static void sendChangeInfoSMS(String mobile) {
		sendSMS(mobile,TEMP_CODE_CHANGE_INFO);
	}
	
	/**
	 * 验证码校验
	 * @param mobile
	 * @param valifyCode
	 * @return
	 */
	public static boolean checkValifyCode(String mobile,String valifyCode,String templateCode,int failureMinutes){
		String code = (String) CacheUtil.getInstance().get(templateCode+mobile);
		Long time = Long.valueOf(CacheUtil.getInstance().get(templateCode+mobile+"time").toString());
		//校验失效时间
		if(((new Date()).getTime() - time)/1000/60 > failureMinutes){
			return false;
		}
		//校验是否一样
		if(valifyCode.equals(code)){
			return true;
		}
		return false;
	}
	
	/**
	 * 默认15分钟失效时间
	 * @param mobile
	 * @param valifyCode
	 * @param templateCode
	 * @return
	 */
	public static boolean checkValifyCode(String mobile,String valifyCode,String templateCode){
		return checkValifyCode(mobile,valifyCode,templateCode,15);
	}
	
	/**
	 * 校验注册验证码
	 * @param mobile
	 * @param valifyCode
	 * @return
	 */
	public static boolean checkRegValifyCode(String mobile,String valifyCode){
		return checkValifyCode(mobile,valifyCode,TEMP_CODE_REG,15);
	}
}
