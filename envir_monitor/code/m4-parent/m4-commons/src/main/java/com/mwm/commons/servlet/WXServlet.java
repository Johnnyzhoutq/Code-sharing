package com.mwm.commons.servlet;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mwm.commons.util.IAnonymousRequest;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.common.util.crypto.SHA1;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

public class WXServlet extends HttpServlet implements IAnonymousRequest {

	protected WxMpInMemoryConfigStorage config;
	protected WxMpService wxMpService;
	protected WxMpMessageRouter wxMpMessageRouter;
	protected static ResourceBundle bundle = PropertyResourceBundle.getBundle("wx");

	@Override
	public void init() throws ServletException {
		super.init();

		config = new WxMpInMemoryConfigStorage();
		config.setAppId(bundle.getString("appid")); 		// 设置微信公众号的appid
		config.setSecret(bundle.getString("appsecret")); 	// 设置微信公众号的app corpSecret
		config.setToken(bundle.getString("token")); 		// 设置微信公众号的token
		config.setAesKey(bundle.getString("aeskry")); 		// 设置微信公众号的EncodingAESKey

		wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(config);

		//文本消息处理
		WxMpMessageHandler textHandler = new WxMpMessageHandler() {
			
			@Override
			public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
					WxSessionManager sessionManager) throws WxErrorException {
				
				WxMpXmlOutTextMessage m = new WxMpXmlOutTextMessage();
				//字符拦截
				/*if(wxMessage.getContent().equals("哈哈")){
					m = WxMpXmlOutMessage.TEXT()
			        	.content("测试回复消息")
			        	.fromUser(wxMessage.getToUserName())
			        	.toUser(wxMessage.getFromUserName()).build();
				}*/
				
				return m;
			}
		};

		//微信消息路由器配置
		wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
		wxMpMessageRouter
			.rule().async(false).msgType(WxConsts.XML_MSG_TEXT).handler(textHandler).end()
		;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		String signature = request.getParameter("signature");
		String nonce = request.getParameter("nonce");
		String timestamp = request.getParameter("timestamp");
		
		//验证消息签名
		if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
			// 消息签名不正确，说明不是公众平台发过来的消息
			response.getWriter().println("非法请求");
			return;
		}

		//校验回调域名
		String echostr = request.getParameter("echostr");
		if (StringUtils.isNotBlank(echostr)) {
			response.getWriter().println(echostr);
			return;
		}

		//明文消息
		String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type")) ? "raw"
				: request.getParameter("encrypt_type");
		if ("raw".equals(encryptType)) {
			// 明文传输的消息
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
			WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
			response.getWriter().write(outMessage.toXml());
			return;
		}

		//加密消息
		if ("aes".equals(encryptType)) {
			// 是aes加密的消息
			String msgSignature = request.getParameter("msg_signature");
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), config,
					timestamp, nonce, msgSignature);
			WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
			response.getWriter().write(outMessage.toEncryptedXml(config));
			return;
		}

		response.getWriter().println("不可识别的加密类型");
		return;
	}
}
