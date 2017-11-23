package com.mwm.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 字符串工具类
 * 
 * @author kunee
 * 
 */
public class StringUtil {
	static Logger log = LoggerFactory.getLogger(StringUtil.class);
	
	/**
	 * 判断字符串是否为null或者空串, 传入字符串将被去除首尾空格后进行判断
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}
}
