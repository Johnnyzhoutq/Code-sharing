package com.mwm.commons.util;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

public class WXUtil {
	//静态变量
	protected static ResourceBundle bundle = PropertyResourceBundle.getBundle("wx");
	public static WxMpInMemoryConfigStorage config;
	public static WxMpService wxMpService;
	
	//初始化配置和服务
	static{
		config = new WxMpInMemoryConfigStorage();
		config.setAppId(bundle.getString("appid")); 		// 设置微信公众号的appid
		config.setSecret(bundle.getString("appsecret")); 	// 设置微信公众号的app corpSecret
		config.setToken(bundle.getString("token")); 		// 设置微信公众号的token
		config.setAesKey(bundle.getString("aeskry")); 		// 设置微信公众号的EncodingAESKey
		config.setPartnerId(bundle.getString("partnerid"));	//商户号
		config.setPartnerKey(bundle.getString("partnerkey"));
		wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(config);
	}
	
	//获取配置
	public static WxMpInMemoryConfigStorage getWxMpConfig(){
		return config;
	}
	
	//配置get方法
	public static WxMpService getWxMpService(){
		return wxMpService;
	}
	
	//获取oauth2跳转连接
	public static String getOauthLink(String redirectURI,String scopeType){
		String returnUrl = wxMpService.oauth2buildAuthorizationUrl(redirectURI, scopeType,null);
		return returnUrl;
	}
	
	public static String getOauthLinkBase(String redirectURI){
		return getOauthLink(redirectURI,WxConsts.OAUTH2_SCOPE_BASE);
	}
	
	public static String getOauthLinkUseInfo(String redirectURI){
		return getOauthLink(redirectURI,WxConsts.OAUTH2_SCOPE_USER_INFO);
	}
	
	//获取调用jssdk的参数
	public static WxJsapiSignature getJsapiSignature(String url) throws WxErrorException{
		return wxMpService.createJsapiSignature(url);
	}
	
	public static WxJsapiSignature getJsapiSignature(HttpServletRequest request) throws WxErrorException{
		String url = WebUtil.getFullUrl(request);
		return wxMpService.createJsapiSignature(url);
	}
}
