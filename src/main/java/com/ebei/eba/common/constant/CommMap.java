package com.ebei.eba.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: yangsm
 * @Date: 2018/8/16 0016
 */
public class CommMap {
    /**
     * 设备状态
     */
    public static final Map<Integer, String> DEVICE_STATE_MAP = new HashMap<Integer, String>();
    public static final Map<Integer, String> FM_DEVICE_TYPE = new HashMap<Integer, String>();
    static
    {
        FM_DEVICE_TYPE.put(Constance.FM_DEVICE_TYPE_EQUIPMENT, "设备");
        FM_DEVICE_TYPE.put(Constance.FM_DEVICE_TYPE_FACILITY, "设施");

        DEVICE_STATE_MAP.put(Constance.DEVICE_STATE_NORMAL, "正常");
        DEVICE_STATE_MAP.put(Constance.DEVICE_STATE_REPAIR, "维修中");
        DEVICE_STATE_MAP.put(Constance.DEVICE_STATE_MAINTENANCE, "维保中");
        DEVICE_STATE_MAP.put(Constance.DEVICE_STATE_NORMAL_SHUTDOWN, "正常关机");
        DEVICE_STATE_MAP.put(Constance.DEVICE_STATE_ABNORMAL_SHUTDOWN, "异常关机");
        DEVICE_STATE_MAP.put(Constance.DEVICE_STATE_BREAKDOWN, "故障中");
        DEVICE_STATE_MAP.put(Constance.DEVICE_STATE_HALT, "停机中");
        DEVICE_STATE_MAP.put(1337, "待机中"); //深交所定制
    }
}
