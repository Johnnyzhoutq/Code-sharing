package com.mwm.commons.commonConst;

/**
 * 系统级const
 * 请勿更改
 * @author Ryan_
 */
public class ExceptionConst {
	
	/**
	 * 统一错误码
	 */
	final public static int RET_CODE_SUCCESS = 600; 						//成功
	final public static String RET_MSG_SUCCESS="操作成功";
	
	final public static int RET_CODE_ERRO_SYS_EXCEPTION=601;				//系统异常	
	final public static String RET_CODE_ERRO_SYS_EXCEPTION_MSG = "系统异常";
	
	final public static int RET_CODE_ERRO_BUS_EXCEPTION=602;				//系统异常	
	final public static String RET_CODE_ERRO_BUS_EXCEPTION_MSG = "系统处理失败";
	
	final public static int RET_CODE_NOT_LOGIN_EXCEPTION = 603;				//未登录异常
	final public static String RET_CODE_NOT_LOGIN_EXCEPTION_MSG = "您未登录或者登录超时!";
	
}
