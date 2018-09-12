package com.ebei.eba.common.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 类描述：建议用此作为所有接口的返回
 *
 * @author wufq
 * @time 2018年5月18日
 */
public class Response<T>{


	public static Map success() {
		return response(null, ResponseEunm.SUCCESS);
	}

	public static Map success(Object result) {
		return response(result, ResponseEunm.SUCCESS);
	}

	public static Map success(Object data, String message) {
		Map result = response(data, ResponseEunm.SUCCESS);
		result.put("ErrorMsg",message);
		return result;
	}

	public static Map success(String message) {
		Map result = response(null, ResponseEunm.SUCCESS);
		result.put("ErrorMsg",message);
		return result;
	}

	public static Map error() {
		return response(null, ResponseEunm.SYSTEM_ERROR);
	}

	public static Map error(String message) {
		Map result = response(null, ResponseEunm.SYSTEM_ERROR);
		result.put("ErrorMsg",message);
		return result;

	}

	public static Map error(ResponseEunm re) {
		return response(null, re);
	}

	public static Map error(String code, String msg) {
		Map<String,Object> result = new HashMap<>();
		result.put("ErrorCode",code);
		result.put("ErrorMsg",msg);
		result.put("Data",null);
		return result;
	}

	public static Map response(Object data, ResponseEunm re) {
		Map<String,Object> result = new HashMap<>();
		result.put("ErrorCode",re.getResponseCode());
		result.put("ErrorMsg",re.getMessage());
		result.put("Data",data);
		return result;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

}
