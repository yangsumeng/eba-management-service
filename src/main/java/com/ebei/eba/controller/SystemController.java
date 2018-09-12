
package com.ebei.eba.controller;

import java.util.Date;
import java.util.Map;
import java.util.List;

import com.ebei.eba.common.constant.Constance;
import com.ebei.eba.common.util.ResponsePageEx;
import com.ebei.eba.common.util.ResponseEx;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import com.baomidou.mybatisplus.plugins.Page;
import com.ebei.eba.model.entity.System;
import com.ebei.eba.service.SystemService;


/** auto code version 1.4
 * <p>
 * 系统表 前端控制器
 * </p>
 * @author JiangP
 * @since 2018-09-03
 */
@RestController
@RequestMapping("/system")
@Api(value = "system" , description = "系统表")
public class SystemController {
	@Autowired
	private SystemService systemService;

	/**自动生成 2018-09-03*/
	@ApiOperation(value = "按照systemID获取详情", notes = "获取system详细信息")
	@ApiImplicitParam(name = "systemId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/byId/{systemId}")
	public ResponseEx<System> getById(@PathVariable String systemId) {

		System system = systemService.selectById(systemId);
        return ResponseEx.createSuccess(system);
	}

	/**自动生成 2018-09-03*/
	@ApiOperation(value="获取分页数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "URL参数：每页显示数量", required = true, paramType = "path"),
			@ApiImplicitParam(name = "pageIndex", value = "URL参数：当前页", required = true, paramType = "path")
	})
	@PostMapping("/pageList/{pageSize}/{pageIndex}")
	public ResponsePageEx<Object> selectMapList(@PathVariable int pageSize, @PathVariable int pageIndex,
												@RequestBody @ApiParam(name="params",value="搜索条件JSON参数，无参请传{}",required=true) Map<String, Object> params) {
        ResponsePageEx<Object>  result = ResponsePageEx.createError("校验未通过");

		if(null == params.get("state")){
			params.put("state", Constance.STATE_YES); //默认查询生效
		}

        if(pageSize > 0 && pageIndex > 0){
			Page<Map<String,Object>> page = systemService.selectMapList(new Page<>(pageIndex, pageSize), params);
			result =  ResponsePageEx.createSuccess(page, page.getTotal(), page.getCurrent(), page.getSize(), page.getPages());
        }
		return result;
	}

	/**自动生成 2018-09-03*/
	@ApiOperation(value="新增system")
	@PostMapping("/saveSystem")
	public ResponseEx<Object> saveSystem(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) System system, @RequestHeader HttpHeaders headers) {
		//String userAccount = headers.getFirst(Constants.USER_HEADER);
		system.setCreator(system.getOperator());
		system.setOperateDate(new Date());
		system.setCreateDate(new Date());
		system.setState(Constance.STATE_YES);
		boolean result = systemService.insert(system);
		if (!result) {
			return ResponseEx.createError("新增失败");
		}
		return ResponseEx.createSuccess("success");
	}
	
	@ApiOperation(value="编辑system")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "systemId", value = "URL参数：systemID", required = true)
	})
	@PostMapping("/editSystem/{systemId}")
	public ResponseEx<Object> editSystem(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) System system, @PathVariable String systemId, @RequestHeader HttpHeaders headers) {
		// 设置主键ID
        //String userAccount = headers.getFirst(Constants.USER_HEADER);
		system.setSystemId(Long.valueOf(systemId));
		system.setOperateDate(new Date());
		boolean result = systemService.updateById(system);
        if (!result) {
        	return ResponseEx.createError("修改失败");
        }
        return ResponseEx.createSuccess("success");
	}

	/**自动生成 2018-09-03*/
	@ApiOperation(value = "通过主键ID逻辑删除", notes = "逻辑删除系统表实体")
	@ApiImplicitParam(name = "systemId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/deleteById/{systemId}")
	public ResponseEx<Object> deleteById(@PathVariable String systemId) {
        boolean ok = systemService.deleteById(Long.valueOf(systemId));
        if(!ok){
        	return ResponseEx.createError("删除失败");
        }
        return ResponseEx.createSuccess("删除成功");
     }

    /**自动生成 2018-09-03 */
    @ApiOperation(value = "获取系统表页面选择框数据", notes = "获取系统表页面选择框数据")
    @PostMapping("/getLabelAndValueList")
    public ResponseEx<Object> getLabelAndValueList(@RequestBody @ApiParam(name="params",value="无参请传{}")  Map<String,Object> params) {
		List<Map<String,Object>> list = systemService.getLabelAndValueList(params);
		return ResponseEx.createSuccess(list);
	}


	/**自动生成 2018-09-03 */
	@ApiOperation(value = "emptyMethod1 方法")
	@GetMapping("/emptyMethod1")
	public ResponseEx<Object> emptyMethod1(){
        Map<String,Object> params = null;
	    Object result = systemService.emptyMethod1(params);
        return ResponseEx.createSuccess("成功");
	}

	/**自动生成 2018-09-03 */
	@ApiOperation(value = "emptyMethod2 方法")
	@GetMapping("/emptyMethod2")
	public ResponseEx<Object> emptyMethod2(){
        Map<String,Object> params = null;
	    Object result = systemService.emptyMethod2(params);
        return ResponseEx.createSuccess("成功");
	}

	@ApiOperation(value = "获取系统树方法", notes = "获取系统树")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "URL参数：每页显示数量", required = true, paramType = "path"),
            @ApiImplicitParam(name = "pageIndex", value = "URL参数：当前页", required = true, paramType = "path")
    })
	@GetMapping("/getSystemTree")
	public ResponseEx<Object> getSystemTree(@RequestParam Long companyId,@RequestParam Long projectId,
			@RequestParam String isAdmin,@RequestParam Integer type) {
		if(companyId == null) {
			return ResponseEx.createError("公司Id为空");
		}
		if(projectId == null) {
			return ResponseEx.createError("项目Id为空");
		}
		// 公司节点查询
		if(type == 1) {
			// 判断是否是公司管理员
			if("1".equals(isAdmin)) {
				// 公司管理员查询，查询改公司下所有项目
				// TODO
			} else {
				// 非公司管理员，只查询该人员项目
				// TODO
				
			}
		} else if(type == 2) {// 项目节点查询
			// 查询该项目下的系统
			// TODO
			
		} else if(type == 3) { // 查询该系统下的机房
			// TODO
		}
		
		
		return ResponseEx.createSuccess("成功");
	}
	
	

}
