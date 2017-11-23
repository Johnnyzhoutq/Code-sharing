package com.mwm.env.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Preconditions;
import com.mwm.commons.exception.MwmRuntimeException;

public class EnvUtils {
	/**
	 * 
	 * @param str   转换成BigDecimal的参数内容
	 * @param name	校验参数字段名称
	 * @return
	 */
	public static BigDecimal strToBigDecimal(String str, String name) {
		try {
			return new BigDecimal(str);
		}
		catch(Exception e) {
			throw new MwmRuntimeException(name + "格式不正确");
		}
	}
	
	/**
	 * 校验字段是否为空，并且长度是否超过数据库字段长度
	 * @param str  校验字段内容
	 * @param name  校验参数字段名称
	 * @param length  校验字段长度
	 */
	public static void validateStrNotNull(String str, String name, int length) {
		Preconditions.checkArgument(StringUtils.isNotBlank(str), "请输入" + name);
		if (str.length() > length) {
			throw new MwmRuntimeException(name + "长度不能超过" + length);
		}
	}
	
	/**
	 * 校验前台传入的Unix时间戳
	 * @param str
	 * @param name  校验参数字段名称
	 */
	public static void validateUnixDate(String unixDate, String name) {
		Preconditions.checkArgument(StringUtils.isNotBlank(unixDate), name + "不能为空");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			sdf.format(new Date(Long.parseLong(unixDate)));
		}
		catch(Exception e) {
			throw new MwmRuntimeException(name + "格式不正确");
		}
		
	}
 }
