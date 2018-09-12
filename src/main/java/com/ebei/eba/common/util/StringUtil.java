package com.ebei.eba.common.util;

public class StringUtil {

	public static boolean isNotEmpty(String str) {
		if(str != null && !"".equals(str)) {
			return true;
		}else {
			return false;
		}
	}
}
