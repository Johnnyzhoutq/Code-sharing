package com.mwm.commons.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.common.base.Preconditions;
import com.mwm.commons.commonConst.ExceptionConst;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.commons.mybatis.modal.UserInfo;
import com.mwm.commons.util.DateJsonValueProcessor;
import com.mwm.commons.util.StringDefaultValueProcessor;
import com.mwm.commons.util.StringUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 
 * @author ryan 2016-6-6 17:22:06
 *
 */
public class BaseController  {
	private static Logger log = LogManager.getLogger(BaseController.class.getName());
	
	protected ThreadLocal<HttpServletRequest> requestThread = new ThreadLocal<HttpServletRequest>();  
    protected ThreadLocal<HttpServletResponse> responseThread = new ThreadLocal<HttpServletResponse>();  
    protected ThreadLocal<HttpSession> sessionThread = new ThreadLocal<HttpSession>();
    protected ThreadLocal<String> requestBodyThread = new ThreadLocal<String>();
    
    //管理后台
    public final static String WEB_URL_MANAGER = "pages-ext/Manager/";
    //CMS
    public final static String WEB_URL_CMS = "pages-ext/MS/";
    //MEMBER
    public final static String WEB_URL_MEMBER = "pages-ext/Member/";
    
    JsonConfig jsonConfig = new JsonConfig(); 
	{
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(int.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Integer.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(double.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Double.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(float.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Float.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(long.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Long.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(BigDecimal.class, new DateJsonValueProcessor());
		jsonConfig.registerDefaultValueProcessor(String.class, new StringDefaultValueProcessor());
	}
      
    @ModelAttribute  
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
    	requestThread.set(request);
    	responseThread.set(response);
    	sessionThread.set(request.getSession());
    	
    	//reader只能取一次，此时需要判断是否需要取reader
    	String contentType = getRequest().getContentType();
    	if(contentType != null && !contentType.toLowerCase().equals("application/x-www-form-urlencoded")){ 
    		try {
    			requestBodyThread.set(getBodyString(request.getReader()));
    		} catch (IOException e) {
    			throw new MwmRuntimeException("请求异常");
    		}
		}
    	
    }  
    
	public HttpServletRequest getRequest() {
		return requestThread.get();
	}

	public HttpServletResponse getResponse() {
		return responseThread.get();
	}
	
	public HttpSession getSession(){
		return sessionThread.get();
	}
	
	public String getRequestBody(){
		return requestBodyThread.get();
	}

	/**
	 * 记录操作日志
	 */
	public void log(){
		
	}
	/**
	 * 获取真实IP
	 */
	public static String getRemoteHost(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
	
	/**
	 * 获取参数
	 */
	public String reqString(String key,boolean filterHtml){
		String value = getRequest().getParameter(key);
		if(StringUtil.isEmpty(value)){
			return "";
		}
		if(filterHtml){
			return StringEscapeUtils.escapeHtml(value.trim());
		}else{
			return value.trim();
		}
	}
	
	public String reqString(String key){
		
		String returnValue = "";//返回值
		
		String method = getRequest().getMethod();
		String contentType = getRequest().getContentType();
		if(!method.equals("GET")){
			Preconditions.checkNotNull(contentType,"请求content-type错误，为application/x-www-form-urlencoded或application/json");
		}
		log.debug("请求方法："+method);
		log.debug("请求类型："+contentType);
		
		if(method.equals("GET")){
			returnValue =  getRequest().getParameter(key) == null?"": getRequest().getParameter(key);
		}else{
			//json方式提交
			if(contentType.toLowerCase().contains("application/json")){ 
				String body = getRequestBody();
				JSONObject jsonObject = JSONObject.fromObject(body);
				if(jsonObject.get(key) !=null){
					returnValue = jsonObject.get(key).toString();
				}
			}
			
			//params方式提交
			if(contentType.toLowerCase().contains("application/x-www-form-urlencoded")){ 
				returnValue =  getRequest().getParameter(key) == null?"": getRequest().getParameter(key);
			}
		}
		
		try {
			if(method.equals("GET")){
				return new String(returnValue.trim().getBytes("ISO8859-1"),"UTF-8");
			}else{
				return returnValue;
			}
			
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static String getBodyString(BufferedReader br) {
	  String inputLine;
	       String str = "";
	     try {
	       while ((inputLine = br.readLine()) != null) {
	        str += inputLine;
	       }
	       br.close();
	     } catch (IOException e) {
	       System.out.println("IOException: " + e);
	     }
	     return str;
	 }
	
	public Integer reqInt(String key,Integer defaultValue){
		//先取requestParams的值
		String paramsValue = getRequest().getParameter(key);
		if(StringUtils.isNotEmpty(paramsValue)){
			return Integer.parseInt(paramsValue);
		}
		
		String value = reqString(key);
		
		if(StringUtils.isEmpty(value)){
			return defaultValue;
		}
		return Integer.parseInt(value);
	}
	
	public Long reqLong(String key,Long defaultValue){
		if(getRequest().getParameter(key) == null || StringUtil.isEmpty(getRequest().getParameter(key))){
			return defaultValue;
		}
		return Long.parseLong(getRequest().getParameter(key));
	}
	
	/**
	 * 获取子类类名
	 */
	public String getClassName(){
		return this.getClass().getSimpleName();
	}
	
	/**
	 * 返回方法名
	 */
	public static String getMethodName(Thread thread){
		return thread.getStackTrace()[1].getMethodName();
	}
	
	/**
	 * 管理后台名
	 */
	public String getManagerUrl(String url){
		return WEB_URL_MANAGER + url;
	}
	
	/**
	 * CMS后台名
	 */
	public String getCmsUrl(String url){
		return WEB_URL_CMS + url;
	}
	
	/**
	 * mwmber后台名
	 */
	public String getMemberUrl(String url){
		return WEB_URL_MEMBER + url;
	}
	
	
	/**
	 * 请求返回成功
	 * @param dataObj
	 */
	protected void setSuccessJsonFromData(Object dataObj){		
		Map retMap = new HashMap();
		retMap.put("code", ExceptionConst.RET_CODE_SUCCESS);
		retMap.put("msg", ExceptionConst.RET_MSG_SUCCESS);
		retMap.put("data", dataObj);		
		try {
			getResponse().setContentType("text/html;charset=UTF-8");
			log.debug("返回结果:" + JSONObject.fromObject(retMap, jsonConfig));
			getResponse().getWriter().println(JSONObject.fromObject(retMap, jsonConfig));
			//getResponse().setContentType("text/html; charset=utf-8");
		} catch (IOException e) {
			log.error("查询错误queryFigureType：", e);
		}
	}

	protected void setSuccessJsonFromData() {
		setSuccessJsonFromData(null);
	}
	
	/**
	 * 返回业务异常
	 * @param dataObj
	 */
	protected void setWrongHandJsonFromData(String dataObj){		
		Map retMap = new HashMap();
		retMap.put("code", ExceptionConst.RET_CODE_ERRO_BUS_EXCEPTION);
		retMap.put("msg", dataObj);	
		try {
			getResponse().setContentType("text/html;charset=UTF-8");
			getResponse().getWriter().println(JSONObject.fromObject(retMap,jsonConfig));
		} catch (IOException e) {
			log.error("查询错误queryFigureType：", e);
		}
	}
	
	/**
	 * 返回系统异常
	 * @param dataObj
	 */
	protected void setExceptionJsonFromData(String dataObj){		
		Map retMap = new HashMap();
		retMap.put("code", ExceptionConst.RET_CODE_ERRO_SYS_EXCEPTION);
		retMap.put("msg", dataObj);	
		try {
			getResponse().setContentType("text/html;charset=UTF-8");
			getResponse().getWriter().println(JSONObject.fromObject(retMap,jsonConfig));
		} catch (IOException e) {
			log.error("查询错误queryFigureType：", e);
		}
	}
	
	/**
	 * 返回其他异常
	 * @param code
	 * @param msg
	 */
	protected void setOtherExcepptionJsonFromData(String code ,String msg){		
		Map retMap = new HashMap();
		retMap.put("code", code);
		retMap.put("msg", msg);	
		try {
			getResponse().setContentType("text/html;charset=UTF-8");
			getResponse().getWriter().println(JSONObject.fromObject(retMap,jsonConfig));
		} catch (IOException e) {
			log.error("查询错误queryFigureType：", e);
		}
	}
	
	
	/**
	 * 获取用户的方法
	 */
	
	protected UserInfo getUser() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserid(55);
		return userInfo;
	}
	/**
	 * 留给shiro的方法
	 */
	
	
}
