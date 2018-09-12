package com.ebei.eba.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hrzong on 2018/5/3.
 */
public interface Constance {

    int REDIS_DEFAULT_EXPIRE_TIME = 21600;

    int REDIS_TYPE_STRING = 0;
    int REDIS_TYPE_HASH = 1;
    int REDIS_TYPE_LIST = 2;
    int REDIS_TYPE_SET = 3;
    int REDIS_TYPE_ZSET = 4;

    Integer STATE_YES = 1;
    Integer STATE_NO = 0;

    String DEFAULT_DATE_FORMATE = "yyyy-MM-dd hh:mm:ss";
    /**
     * 设备状态：1-正常
     */
    int DEVICE_STATE_NORMAL = 1;

    /**
     * 设备状态：2-维修中
     */
    int DEVICE_STATE_REPAIR = 2;

    /**
     * 设备状态：3-维保中
     */
    int DEVICE_STATE_MAINTENANCE = 3;

    /**
     * 设备状态：4-正常关机
     */
    int DEVICE_STATE_NORMAL_SHUTDOWN = 4;

    /**
     * 设备状态：5-异常关机
     */
    int DEVICE_STATE_ABNORMAL_SHUTDOWN = 5;

    /**
     * 设备状态：6-故障中
     */
    int DEVICE_STATE_BREAKDOWN = 6;

    /**
     * 设备状态：7-停机中
     */
    int DEVICE_STATE_HALT = 7;

    /**
     * 类型——1：设备
     */
    int FM_DEVICE_TYPE_EQUIPMENT = 1;

    /**
     * 类型——2：设施
     */
    int FM_DEVICE_TYPE_FACILITY = 2;
}
