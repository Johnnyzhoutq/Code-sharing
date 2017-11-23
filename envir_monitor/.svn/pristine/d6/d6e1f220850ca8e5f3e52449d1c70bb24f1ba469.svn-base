package com.mwm.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mwm.commons.commonConst.Const;
import com.mwm.commons.util.StringUtil;

public class MwmParamInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		request.setAttribute("basePath", getBasePath(request));
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		return true;
	}
	
	/**
	 * 获取基础路径
	 * 
	 * @param request
	 * @return
	 */
	private String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		if(Const.IS_DEPLOY_WITH_CONTEXT.equalsIgnoreCase("false")){
			path = "";
		}
		
		String port = request.getServerPort() == 80?"":String.valueOf(request.getServerPort());

		String basePath = request.getScheme() + "://" + request.getServerName()
				+ (StringUtil.isEmpty(port) ? "":(":" + port)) 
			    + (StringUtil.isEmpty(path) ? "/":(path + "/"));
		return basePath;
	}

}
