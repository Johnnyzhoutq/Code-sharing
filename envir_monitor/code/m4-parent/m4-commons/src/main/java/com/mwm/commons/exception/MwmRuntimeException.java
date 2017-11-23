package com.mwm.commons.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

import com.mwm.commons.commonConst.ExceptionConst;

/**
 * 运行时异常，所有uncheck的运行时异常都用这个类
 */
public class MwmRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -7636252675570711205L;
	private Result result;

	/**
	 * 构造方法
	 * @param result 返回值
	 * @param cause  异常堆栈
	 */
	public MwmRuntimeException(Result result, Throwable cause) {
		super(result.getMsg(), cause);
		this.result = result;
	}

	/**
	 * 构造方法
	 * @param code 返回码
	 * @param msg  错误消息
	 */
	public MwmRuntimeException(int code, String msg) {
		super(msg);
		this.result = new Result(code, msg);
	}
	
	/**
	 * 构造方法
	 * @param code 返回码
	 * @param msg  错误消息
	 */
	public MwmRuntimeException(String msg) {
		super(msg);
		this.result = new Result(ExceptionConst.RET_CODE_ERRO_SYS_EXCEPTION, msg);
	}

	/**
	 * 构造方法
	 * @param result 返回值
	 * @param detail 具体的返回消息
	 */
	public MwmRuntimeException(Result result, String detail) {
		super(result.getMsg() + "," + detail);
		this.result = new Result(result.getCode(), result.getMsg() + "," + detail);
	}

	/**
	 * 构造方法
	 * @param result 返回值
	 * @param detail 具体的返回消息
	 * @param cause  异常堆栈
	 */
	public MwmRuntimeException(Result result, String detail, Throwable cause) {
		super(result.getMsg() + "," + detail, cause);
		this.result = new Result(result.getCode(), result.getMsg() + "," + detail);
	}

	/**
	 * 构造方法
	 * @param code	返回码
	 * @param msg	返回消息
	 * @param cause 异常堆栈
	 */
	public MwmRuntimeException(int code, String msg, Throwable cause) {
		super(msg, cause);
		this.result = new Result(code, msg);
	}

	/**
	 * 构造方法
	 * @param code	返回码
	 * @param cause	异常堆栈
	 */
	public MwmRuntimeException(int code, Throwable cause) {
		super(cause);
		this.result = new Result(code, null);
	}

	/**
	 * 异常
	 * @return
	 */
	public String toXmlString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<exception>");
		
		if (getResult() != null)
			sb.append(result.toString());

		sb.append("<exceptionTrace>");
		sb.append(getMessage());
		sb.append("</exceptionTrace>");
		
		sb.append("<exception/>");
		return sb.toString();
	}

	@Override
	public void printStackTrace(PrintStream ps) {
		ps.print("<exception>");
		if (getResult() != null) {
			ps.print(result.toString());
		} 
		ps.append("<exceptionTrace>");
		
		Throwable cause = getCause();
		if (cause == null) {
			super.printStackTrace(ps);
		} else {
			ps.println(this);
			ps.print("Caused by: ");
			cause.printStackTrace(ps);
		}
		ps.append("</exceptionTrace>");
		ps.println("</exception>");
	}

	@Override
	public void printStackTrace(PrintWriter pw) {
		pw.print("<exception>");
		if (getResult() != null) {
			pw.print(result.toString());
		} 
		pw.append("<exceptionTrace>");
		
		Throwable cause = getCause();
		if (cause == null) {
			super.printStackTrace(pw);
		} else {
			pw.println(this);
			pw.print("Caused by: ");
			cause.printStackTrace(pw);
		}
		pw.append("</exceptionTrace>");
		pw.println("</exception>");
	}

	/**
	 * 返回异常值
	 * @return	异常值对象
	 */
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
