package com.mwm.env.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mwm.commons.controller.BaseController;
import com.mwm.commons.util.IAnonymousRequest;

@Controller
@RequestMapping()
public class TestController extends BaseController implements IAnonymousRequest{
	
	/**
	 * @api {GET} /user 获取用户信息
	 * @apiName getUserInfo
	 * @apiGroup user
	 *
	 * @apiParam {String} userPhone 手机号码
	 * @apiParam {String} verifyNum 短信验证码
	 */
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void test(HttpSession session){
		session.setAttribute("userid", "111111");
		this.setSuccessJsonFromData();
	}
}
