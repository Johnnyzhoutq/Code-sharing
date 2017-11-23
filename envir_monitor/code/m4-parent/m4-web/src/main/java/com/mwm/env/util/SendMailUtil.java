package com.mwm.env.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SendMailUtil {
	
	/**
	 * 发送邮件
	 * @param toUser 收件人邮箱
	 * @param subject 邮件主题
	 * @param htmlMessage 邮件内容
	 * @throws IOException
	 */
	public void senMail(String toUser, String subject,String htmlMessage) throws IOException {
	      final String url = "http://sendcloud.sohu.com/webapi/mail.send.json";
	      final String apiUser = "thickskin_test_aooULz";
	      final String apiKey = "niid9HwemksoJsIq";

	      HttpClient httpclient = new DefaultHttpClient();
	      HttpPost httpost = new HttpPost(url);

	      List params = new ArrayList();
	      // 不同于登录SendCloud站点的帐号，您需要登录后台创建发信子帐号，使用子帐号和密码才可以进行邮件的发送。
	      params.add(new BasicNameValuePair("api_user", apiUser));
	      params.add(new BasicNameValuePair("api_key", apiKey));
	      params.add(new BasicNameValuePair("from", "service@env.com"));
	      params.add(new BasicNameValuePair("fromname", ""));
	      params.add(new BasicNameValuePair("to", toUser));
	      params.add(new BasicNameValuePair("subject", subject));
	      params.add(new BasicNameValuePair("html", htmlMessage));
	      params.add(new BasicNameValuePair("resp_email_id", "true"));

	      httpost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
	      // 请求
	      HttpResponse response = httpclient.execute(httpost);
	      // 处理响应
	      if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
	        // 读取xml文档
	        String result = EntityUtils.toString(response.getEntity());
	      } else {
	        System.err.println("error");
	      }
	      httpost.releaseConnection();
	}
}
