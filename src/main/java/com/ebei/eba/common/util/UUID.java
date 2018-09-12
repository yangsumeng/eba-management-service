package com.ebei.eba.common.util;

/**
 * Description:生成唯一id
 *
 * @author xu
 * @date:2018/4/28
 * @Copyright (c) 2018 一碑科技
 */
public class UUID {
    public static String  getId(){return java.util.UUID.randomUUID().toString();}
}
