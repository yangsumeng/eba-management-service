package com.ebei.eba.common.util;


public class EbeiException extends RuntimeException {

	/**
	 * 变量描述：异常处理类
	 * @date:2018年5月21日
	 * @Copyright (c) 2018 一碑科技
	 * @version
	 * @author wufq
	 */

	private static final long serialVersionUID = -5550382124741152110L;

	private String code;
	private String msg;

	private EbeiException(String code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	private EbeiException(String code, String msg, Throwable exception) {
		super(msg, exception);
		this.code = code;
		this.msg = msg;
	}

	public static void throwException(String code, String msg) {
		throw new EbeiException(code, msg);
	}

	public static void throwException(ResponseEunm eunm) {
		throw new EbeiException(eunm.getResponseCode(), eunm.getMessage());
	}
	
	public static void throwException(String msg) {
		throw new EbeiException(ResponseEunm.SYSTEM_ERROR.getResponseCode(),msg);
	}
	
	public static void throwException(ResponseEunm eunm,String message) {
		throw new EbeiException(eunm.getResponseCode(), message);
	}

	public static void throwException(String code, String msg, Throwable exception) {
		throw new EbeiException(code, msg, exception);
	}

	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
