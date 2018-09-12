package com.ebei.eba.common.util;
/**
 * 
 * 类描述：接口状态码枚举
 *
 * @author wufq
 * @time 2018年5月18日 下午2:16:52
 */
public enum ResponseEunm {
	SUCCESS("0", "操作成功"),
	FAIL("1", "操作失败"),
	PARAMS_DISABLE("11", "参数不足或非法"),
	SYSTEM_ERROR("12","系统异常");
	
	private String responseCode;

	private String message;

	private ResponseEunm(String code, String message) {
		this.responseCode = code;
		this.message = message;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
