package com.ebei.eba.service;

import java.util.List;
import java.util.Map;

import com.ebei.eba.model.entity.User;
import com.baomidou.mybatisplus.service.IService;

import com.baomidou.mybatisplus.plugins.Page;

/**	auto code version 1.4
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author JiangP
 * @since 2018-09-03
 */
public interface UserService extends IService<User> {
	/**自动生成 2018-09-03 */
    public Page<Map<String,Object>> selectMapList(Page<Map<String,Object>> page, Map<String,Object> params);

	/**自动生成 2018-09-03 */
    public List<Map<String,Object>> getLabelAndValueList(Map<String,Object> params);

	/**
	 *  emptyMethod1 方法
	 *  自动生成 2018-09-03
	 */
	public List<Map<String,Object>> emptyMethod1(Map<String,Object> params);
	/**
	 *  emptyMethod2 方法
	 *  自动生成 2018-09-03
	 */
	public List<Map<String,Object>> emptyMethod2(Map<String,Object> params);
	/**
	 *  getShowDeviceLevelPage 方法
	 *  自动生成 2018-09-03
	 */
	public List<Map<String,Object>> getShowDeviceLevelPage(Page<Map<String,Object>> page,Map<String,Object> params);
	
	/**
	 * 
	 * @Description :根据用户账户查询用户信息
	 * @param userAccount
	 * @return 
	 * @author JiangPing
	 */
	User getByAccount(String userAccount);
}
