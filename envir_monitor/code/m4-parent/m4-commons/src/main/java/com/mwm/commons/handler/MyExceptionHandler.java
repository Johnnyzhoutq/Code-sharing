package com.mwm.commons.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.mwm.commons.commonConst.ExceptionConst;
import com.mwm.commons.exception.MwmNotLoginException;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.commons.util.WebUtil;

import net.sf.json.JSONObject;

public class MyExceptionHandler implements HandlerExceptionResolver{
	private static Logger log = LogManager.getLogger(MyExceptionHandler.class.getName());

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception exception) {
		
		Map<String, Object> model = new HashMap<String, Object>();  
		model.put("exception", exception);
		log.error("异常:", exception);
		
		if(exception instanceof MwmNotLoginException){	//未登录的异常
			JSONObject resultJson = new JSONObject();
			resultJson.put("code", ExceptionConst.RET_CODE_NOT_LOGIN_EXCEPTION);
			resultJson.put("msg", ExceptionConst.RET_CODE_NOT_LOGIN_EXCEPTION_MSG);
			request.setAttribute("JSON_RESULT", resultJson.toString());
			request.setAttribute("url", "../SMHome/login");
			return new ModelAndView("pages/Common/forbid", model);
		}else if(exception instanceof MwmRuntimeException){ //业务异常
			JSONObject resultJson = new JSONObject();
			resultJson.put("code", ((MwmRuntimeException) exception).getResult().getCode());
			resultJson.put("msg", ((MwmRuntimeException) exception).getResult().getMsg());
			request.setAttribute("JSON_RESULT", resultJson.toString());
			if(WebUtil.isAjaxRequest(request)){
				return new ModelAndView("pages/Common/json", model);
			}else{
				return new ModelAndView("pages/Common/exception", model);
			}
		}else{ //其他异常
			JSONObject resultJson = new JSONObject();
			resultJson.put("code", ExceptionConst.RET_CODE_ERRO_SYS_EXCEPTION);
			//resultJson.put("msg", ExceptionConst.RET_CODE_ERRO_SYS_EXCEPTION_MSG);
			resultJson.put("msg", exception.getMessage());
			request.setAttribute("JSON_RESULT", resultJson.toString());
			if(WebUtil.isAjaxRequest(request)){
				return new ModelAndView("pages/Common/json", model);
			}else{
				return new ModelAndView("pages/Common/exception", model);
			}
		}
	}

}
