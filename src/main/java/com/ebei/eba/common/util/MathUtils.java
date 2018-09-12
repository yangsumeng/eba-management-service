package com.ebei.eba.common.util;

import java.math.BigDecimal;

/**
 * 
 * @Description : 精确计算
 * @time 创建时间 : 2017年2月18日
 * @author : FanHua
 * @Copyright (c) 2017 一碑科技
 * @version
 */
public class MathUtils {
	/**
	 * 
	 * Description : 加法运算,保留精度(四舍五入)
	 * @param v1
	 * @param v2
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double add(double v1, double v2, int scale) {
		return MathUtils.add(Double.toString(v1), Double.toString(v2), scale);
	}
	
	/**
	 * 
	 * Description : 加法运算,保留精度(四舍五入)
	 * @param v1
	 * @param v2
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double add(String v1, String v2, int scale) {
		return MathUtils.add(v1, v2, scale, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 
	 * Description : 加法运算,按舍入类别保留精度
	 * @param v1
	 * @param v2
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double add(double v1, double v2, int scale, int roundType) {
		return MathUtils.add(Double.toString(v1), Double.toString(v2), scale, roundType);
	}
	
	/**
	 * 
	 * Description : 加法运算,按舍入类别保留精度
	 * @param v1
	 * @param v2
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double add(String v1, String v2, int scale, int roundType) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).setScale(scale, roundType).doubleValue();
	}

	/**
	 * 
	 * Description : 减法运算,保留精度(四舍五入)
	 * @param v1 被减数
	 * @param v2 减数
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double subtract(double v1, double v2, int scale) {
		return MathUtils.subtract(Double.toString(v1), Double.toString(v2), scale);
	}
	
	/**
	 * 
	 * Description : 减法运算,保留精度(四舍五入)
	 * @param v1 被减数
	 * @param v2 减数
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double subtract(String v1, String v2, int scale) {
		return MathUtils.subtract(v1, v2, scale, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 
	 * Description : 减法运算,按舍入类别保留精度
	 * @param v1 被减数
	 * @param v2 减数
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double subtract(double v1, double v2, int scale, int roundType) {
		return MathUtils.subtract(Double.toString(v1), Double.toString(v2), scale, roundType);
	}
	
	/**
	 * 
	 * Description : 减法运算,按舍入类别保留精度
	 * @param v1 被减数
	 * @param v2 减数
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double subtract(String v1, String v2, int scale, int roundType) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).setScale(scale, roundType).doubleValue();
	}

	/**
	 * 
	 * Description : 乘法运算,保留精度(四舍五入)
	 * @param v1
	 * @param v2
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double multiply(double v1, double v2, int scale) {
		return MathUtils.multiply(Double.toString(v1), Double.toString(v2), scale);
	}
	
	/**
	 * 
	 * Description : 乘法运算,保留精度(四舍五入)
	 * @param v1
	 * @param v2
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double multiply(String v1, String v2, int scale) {
		return MathUtils.multiply(v1, v2, scale, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 
	 * Description : 乘法运算,按舍入类别保留精度
	 * @param v1
	 * @param v2
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double multiply(double v1, double v2, int scale, int roundType) {
		return MathUtils.multiply(Double.toString(v1), Double.toString(v2), scale, roundType);
	}
	
	/**
	 * 
	 * Description : 乘法运算,按舍入类别保留精度
	 * @param v1
	 * @param v2
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double multiply(String v1, String v2, int scale, int roundType) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).setScale(scale, roundType).doubleValue();
	}

	/**
	 * 
	 * Description : 除法运算,保留精度(四舍五入)
	 * @param v1  被除数
	 * @param v2 除数
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double divide(double v1, double v2, int scale) {
		return MathUtils.divide(Double.toString(v1), Double.toString(v2), scale);
	}
	
	/**
	 * 
	 * Description : 除法运算,保留精度(四舍五入)
	 * @param v1  被除数
	 * @param v2 除数
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double divide(String v1, String v2, int scale) {
		return MathUtils.divide(v1, v2, scale, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 
	 * Description : 除法运算,按舍入类别保留精度
	 * @param v1  被除数
	 * @param v2 除数
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double divide(double v1, double v2, int scale, int roundType) {
		return MathUtils.divide(Double.toString(v1), Double.toString(v2), scale, roundType);
	}
	
	/**
	 * 
	 * Description : 除法运算,按舍入类别保留精度
	 * @param v1  被除数
	 * @param v2 除数
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double divide(String v1, String v2, int scale, int roundType) {
		if (Double.valueOf(v2) == 0.0) {
			throw new ArithmeticException("/ by zero");
		}
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, roundType).doubleValue();
	}

	/**
	 * 
	 * Description : 四舍五入
	 * @param v
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double round(double v, int scale) {
		return MathUtils.round(Double.toString(v), scale);
	}
	
	/**
	 * 
	 * Description : 四舍五入
	 * @param v
	 * @param scale 精度
	 * @author DeanFan
	 */
	public static double round(String v, int scale) {
		return MathUtils.round(v, scale, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 
	 * Description : 按舍入类别保留精度
	 * @param v
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double round(double v, int scale, int roundType) {
		return MathUtils.round(Double.toString(v), scale, roundType);
	}
	
	/**
	 * 
	 * Description : 按舍入类别保留精度
	 * @param v
	 * @param scale 精度
	 * @param roundType 舍入类别<br>
	 * 例：BigDecimal.ROUND_HALF_UP
	 * @author DeanFan
	 */
	public static double round(String v, int scale, int roundType) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(v);
		return b.setScale(scale, roundType).doubleValue();
	}

	/**
	 * 是否不是一个数字
	 * isNotANumber
	 * @param value
	 * @return
	 */
	public static boolean isNaN(Object value){
		boolean result=value.toString().matches("[0-9]+");
		return !result;
	}
	
	/**
	 * 
	 * Description : 加法运算，不保留精度
	 * @param v1
	 * @param v2
	 * @author Lisw
	 */
	public static double add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).doubleValue();
	}
	
	/**
	 * 
	 * Description : 加法运算，不保留精度
	 * @param v1
	 * @param v2
	 * @author Lisw
	 */
	public static double add(double v1, double v2) {
		return MathUtils.add(Double.toString(v1), Double.toString(v2));
	}
	
	/**
	 * 
	 * Description : 乘法运算，不保留精度
	 * @param v1
	 * @param v2
	 * @author Lisw
	 */
	public static double multiply(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).doubleValue();
	}
	
	/**
	 * 
	 * Description :乘法运算，不保留精度
	 * @param v1
	 * @param v2
	 * @author Lisw
	 */
	public static double multiply(double v1, double v2) {
		return MathUtils.multiply(Double.toString(v1), Double.toString(v2));
	}
	
	/**
	 * 
	 * Description : 减法运算，不保留精度
	 * @param v1
	 * @param v2
	 * @author Lisw
	 */
	public static double subtract(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).doubleValue();
	}
	
	/**
	 * 
	 * Description : 减法运算，不保留精度
	 * @param v1
	 * @param v2
	 * @author Lisw
	 */
	public static double subtract(double v1, double v2) {
		return MathUtils.subtract(Double.toString(v1), Double.toString(v2));
	}
	
	/**
	 * 
	 * Description : 除法运算，不保留精度
	 * @param v1
	 * @param v2
	 * @author Lisw
	 */
	public static double divide(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2).doubleValue();
	}
	
	/**
	 * 
	 * Description : 除法运算，不保留精度
	 * @param v1
	 * @param v2
	 * @author Lisw
	 */
	public static double divide(double v1, double v2) {
		return MathUtils.divide(Double.toString(v1), Double.toString(v2));
	}
	
}
