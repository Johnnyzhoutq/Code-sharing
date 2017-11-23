package com.mwm.env.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.env.mybatis.modal.ProvideInfo;
import com.mwm.env.mybatis.modal.UserInfo;

public class UserUtil {

	public static UserInfo getUser(HttpServletRequest request){
		/*if(request.getSession().getAttribute("user") == null){
			throw new MwmRuntimeException(605, "登陆信息失效，请重新登陆");
		}
		return (UserInfo) request.getSession().getAttribute("user");*/
		
		UserInfo user = new UserInfo();
		user.setUserid(1);
		return user;
	}
	
	public static ProvideInfo getProvider(HttpServletRequest request){
		/*if(request.getSession().getAttribute("provide") == null){
			throw new MwmRuntimeException(605, "供应商信息失效，请重新登陆");
		}
		return (ProvideInfo) request.getSession().getAttribute("provide");
		*/
		ProvideInfo provider = new ProvideInfo();
		provider.setProvideid(1);
		return provider;
	}
}
