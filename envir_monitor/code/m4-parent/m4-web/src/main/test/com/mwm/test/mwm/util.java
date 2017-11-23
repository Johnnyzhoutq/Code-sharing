package com.mwm.test.mwm;

import com.mwm.commons.util.SMSUtil;

public class util {

	/**
	 * 短信发送和检验
	 * @throws InterruptedException 
	 */
	public void aboutSMS() throws InterruptedException{
		//1、已经在sms.properties中定义了7种业务类型短信，新增短信类型需要提交审核
		//2、如果提示校验失败，检查config表中的TITLE是否正确
		//3、默认发送六位数字验证码
		//4、demo如下
		
		//发送注册短信
		SMSUtil.sendRegSMS("158XXXX");
		//发送修改密码短信
		SMSUtil.sendChangePasswdSMS("158XXXX");
		
		
		//检验收到的验证码，
		boolean isRight = SMSUtil.checkValifyCode("158XXXX", "859475",SMSUtil.TEMP_CODE_REG);
		boolean isRights = SMSUtil.checkValifyCode("158XXXX", "859475",SMSUtil.TEMP_CODE_REG,15);
	}
}
