package com.ebei.eba.service.impl;

import java.util.List;
import java.util.Map;

import com.ebei.eba.model.entity.LevelParam;
import com.ebei.eba.mapper.LevelParamMapper;
import com.ebei.eba.service.LevelParamService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;

/**	auto code version 1.4
 * <p>
 * 级别参数 服务实现类
 * </p>
 *
 * @author JiangP
 * @since 2018-09-03
 */
@Service
public class LevelParamServiceImpl extends ServiceImpl<LevelParamMapper, LevelParam> implements LevelParamService {

    @Autowired
	LevelParamMapper  levelParamMapper;
	/**自动生成 2018-09-03 */
    @Override
	public Page<Map<String,Object>> selectMapList(Page<Map<String,Object>> page, Map<String,Object> params) {
		List<Map<String,Object>> list = levelParamMapper.selectMapList(page,params);
		return page.setRecords(list);
	}

            /**
             * 级别参数 获取页面选择列表
             *
             * @author JiangP
             * @since 2018-09-03
			 * 自动生成 2018-09-03
             */
	public List<Map<String,Object>> getLabelAndValueList(Map<String,Object> params){
		List<Map<String,Object>> list = levelParamMapper.getLabelAndValueList(params);
		return list;
	}

	/**
	 *  emptyMethod1 方法
	 *  自动生成 2018-09-03
	 */
	public List<Map<String,Object>> emptyMethod1(Map<String,Object> params){
        List<Map<String,Object>> result = levelParamMapper.emptyMethod1(params);
        return result;
	}
	/**
	 *  emptyMethod2 方法
	 *  自动生成 2018-09-03
	 */
	public List<Map<String,Object>> emptyMethod2(Map<String,Object> params){
        List<Map<String,Object>> result = levelParamMapper.emptyMethod2(params);
        return result;
	}
	/**
	 *  getShowDeviceLevelPage 方法
	 *  自动生成 2018-09-03
	 */
	public List<Map<String,Object>> getShowDeviceLevelPage(Page<Map<String,Object>> page,Map<String,Object> params){
        List<Map<String,Object>> result = levelParamMapper.getShowDeviceLevelPage(page,params);
        return result;
	}
}
