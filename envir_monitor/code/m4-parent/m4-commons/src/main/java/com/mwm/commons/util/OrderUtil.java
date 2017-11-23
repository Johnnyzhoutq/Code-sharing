package com.mwm.commons.util;

import java.util.Date;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 订单公用方法
 * @author hery
 *
 */
public class OrderUtil {

	/**
	 * 生成订单编号
	 */
	public static String getOrderNum(){
		String orderNum = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + RandomStringUtils.randomNumeric(6);
		return orderNum;
	}
	
	/**
	 * 生成取货码
	 * @return
	 */
	public static String getTakeCode(){
		String takeCode = RandomStringUtils.randomNumeric(6);
		return takeCode;
	}
}
