package com.ebei.eba.service.impl;

import java.util.List;
import java.util.Map;

import com.ebei.eba.model.entity.Device;
import com.ebei.eba.mapper.DeviceMapper;
import com.ebei.eba.service.DeviceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;

/**	auto code version 1.4
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author JiangP
 * @since 2018-09-10
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Autowired
	DeviceMapper  deviceMapper;
	/**自动生成 2018-09-10 */
    @Override
	public Page<Map<String,Object>> selectMapList(Page<Map<String,Object>> page, Map<String,Object> params) {
		List<Map<String,Object>> list = deviceMapper.selectMapList(page,params);
		return page.setRecords(list);
	}

            /**
             * 设备表 获取页面选择列表
             *
             * @author JiangP
             * @since 2018-09-10
			 * 自动生成 2018-09-10
             */
	public List<Map<String,Object>> getLabelAndValueList(Map<String,Object> params){
		List<Map<String,Object>> list = deviceMapper.getLabelAndValueList(params);
		return list;
	}

	/**
	 *  emptyMethod1 方法
	 *  自动生成 2018-09-10
	 */
	public List<Map<String,Object>> emptyMethod1(Map<String,Object> params){
        List<Map<String,Object>> result = deviceMapper.emptyMethod1(params);
        return result;
	}
	/**
	 *  emptyMethod2 方法
	 *  自动生成 2018-09-10
	 */
	public List<Map<String,Object>> emptyMethod2(Map<String,Object> params){
        List<Map<String,Object>> result = deviceMapper.emptyMethod2(params);
        return result;
	}
	/**
	 *  getShowDeviceLevelPage 方法
	 *  自动生成 2018-09-10
	 */
	public List<Map<String,Object>> getShowDeviceLevelPage(Page<Map<String,Object>> page,Map<String,Object> params){
        List<Map<String,Object>> result = deviceMapper.getShowDeviceLevelPage(page,params);
        return result;
	}
}
