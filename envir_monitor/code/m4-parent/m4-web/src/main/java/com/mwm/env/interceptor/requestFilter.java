package com.mwm.env.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.mwm.commons.commonConst.ExceptionConst;
import com.mwm.commons.exception.MwmRuntimeException;

import net.sf.json.JSONObject;

public class requestFilter extends OncePerRequestFilter{
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
        String method = request.getMethod();
		if(method.equals("OPTIONS")){
			JSONObject retJo = new JSONObject();
			retJo.element("code", "600");
			retJo.element("msg", "");
			retJo.element("data", "");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
			response.setHeader("Access-Control-Max-Age", "360000");
			response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
			response.getWriter().println(retJo.toString());
		}else{
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
			response.setHeader("Access-Control-Max-Age", "360000");
			response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
			
		}
		
        filterChain.doFilter(request, response);
		
		
	}

	

}
