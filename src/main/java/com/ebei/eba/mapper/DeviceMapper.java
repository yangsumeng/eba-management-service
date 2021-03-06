package com.ebei.eba.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ebei.eba.model.entity.Device;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/** auto code version 1.4
 * 
 * @Description : DeviceMapper
 * @time 创建时间 : 2018-09-10
 * @author : JiangP
 * @Copyright (c) ${year} 一碑科技
 * @version
 */
@Repository
public interface DeviceMapper extends BaseMapper<Device> {
    /**自动生成 2018-09-10 */
    public List<Map<String,Object>> selectMapList(Page<Map<String,Object>> page, Map params);
    /**自动生成 2018-09-10 */
    public List<Map<String,Object>> getLabelAndValueList(Map<String,Object> params);

    /**
     *  emptyMethod1 方法
     *  自动生成 2018-09-10
     */
    public List<Map<String,Object>> emptyMethod1(Map<String,Object> params);
    /**
     *  emptyMethod2 方法
     *  自动生成 2018-09-10
     */
    public List<Map<String,Object>> emptyMethod2(Map<String,Object> params);
    /**
     *  getShowDeviceLevelPage 方法
     *  自动生成 2018-09-10
     */
    public List<Map<String,Object>> getShowDeviceLevelPage(Page<Map<String,Object>> page,Map<String,Object> params);
}
