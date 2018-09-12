package com.ebei.eba.common.util;


/**
 * @Author: Huangweicai
 * @date 2018-02-05 21:35
 * @Description:
 */
public class ResponseConstants {

	//成功
    public static final Integer CODE_SUCCESS = 200;

    //Token失效，或者未传Token，或者没有权限
    public static final Integer CODE_UNAUTHORIATION = 401;
    
    //内部未知错误
    public static final Integer CODE_ERROR   = 500;
    
    //业务错误  例 : 参数不匹配或参数验证不正确
    public static final Integer CODE_BUSINESS_ERROR = 300;


    //没有数据时返回
    public static final Integer CODE_NO_DATA = 250;
}
