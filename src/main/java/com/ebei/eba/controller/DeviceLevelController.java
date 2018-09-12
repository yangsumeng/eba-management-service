
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
import com.ebei.eba.model.entity.DeviceLevel;
import com.ebei.eba.service.DeviceLevelService;


/** auto code version 1.4
 * <p>
 * 设备级别（类型） 前端控制器
 * </p>
 * @author JiangP
 * @since 2018-09-03
 */
@RestController
@RequestMapping("/deviceLevel")
@Api(value = "deviceLevel" , description = "设备级别（类型）")
public class DeviceLevelController {
	@Autowired
	private DeviceLevelService deviceLevelService;

	/**自动生成 2018-09-03*/
	@ApiOperation(value = "按照deviceLevelID获取详情", notes = "获取deviceLevel详细信息")
	@ApiImplicitParam(name = "deviceLevelId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/byId/{deviceLevelId}")
	public ResponseEx<DeviceLevel> getById(@PathVariable String deviceLevelId) {

		DeviceLevel deviceLevel = deviceLevelService.selectById(deviceLevelId);
        return ResponseEx.createSuccess(deviceLevel);
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
			Page<Map<String,Object>> page = deviceLevelService.selectMapList(new Page<>(pageIndex, pageSize), params);
			result =  ResponsePageEx.createSuccess(page, page.getTotal(), page.getCurrent(), page.getSize(), page.getPages());
        }
		return result;
	}

	/**自动生成 2018-09-03*/
	@ApiOperation(value="新增deviceLevel")
	@PostMapping("/saveDeviceLevel")
	public ResponseEx<Object> saveDeviceLevel(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) DeviceLevel deviceLevel, @RequestHeader HttpHeaders headers) {
		//String userAccount = headers.getFirst(Constants.USER_HEADER);
		deviceLevel.setCreator(deviceLevel.getOperator());
		deviceLevel.setOperateDate(new Date());
		deviceLevel.setCreateDate(new Date());
		deviceLevel.setState(Constance.STATE_YES);
		boolean result = deviceLevelService.insert(deviceLevel);
		if (!result) {
			return ResponseEx.createError("新增失败");
		}
		return ResponseEx.createSuccess("success");
	}
	
	@ApiOperation(value="编辑deviceLevel")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "deviceLevelId", value = "URL参数：deviceLevelID", required = true)
	})
	@PostMapping("/editDeviceLevel/{deviceLevelId}")
	public ResponseEx<Object> editDeviceLevel(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) DeviceLevel deviceLevel, @PathVariable String deviceLevelId, @RequestHeader HttpHeaders headers) {
		// 设置主键ID
        //String userAccount = headers.getFirst(Constants.USER_HEADER);
		deviceLevel.setLevelId(Long.valueOf(deviceLevelId));
		deviceLevel.setOperateDate(new Date());
		boolean result = deviceLevelService.updateById(deviceLevel);
        if (!result) {
        	return ResponseEx.createError("修改失败");
        }
        return ResponseEx.createSuccess("success");
	}

	/**自动生成 2018-09-03*/
	@ApiOperation(value = "通过主键ID逻辑删除", notes = "逻辑删除设备级别（类型）实体")
	@ApiImplicitParam(name = "deviceLevelId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/deleteById/{deviceLevelId}")
	public ResponseEx<Object> deleteById(@PathVariable String deviceLevelId) {
        boolean ok = deviceLevelService.deleteById(Long.valueOf(deviceLevelId));
        if(!ok){
        	return ResponseEx.createError("删除失败");
        }
        return ResponseEx.createSuccess("删除成功");
     }

    /**自动生成 2018-09-03 */
    @ApiOperation(value = "获取设备级别（类型）页面选择框数据", notes = "获取设备级别（类型）页面选择框数据")
    @PostMapping("/getLabelAndValueList")
    public ResponseEx<Object> getLabelAndValueList(@RequestBody @ApiParam(name="params",value="无参请传{}")  Map<String,Object> params) {
		List<Map<String,Object>> list = deviceLevelService.getLabelAndValueList(params);
		return ResponseEx.createSuccess(list);
	}


	/**自动生成 2018-09-03 */
	@ApiOperation(value = "emptyMethod1 方法")
	@GetMapping("/emptyMethod1")
	public ResponseEx<Object> emptyMethod1(){
        Map<String,Object> params = null;
	    Object result = deviceLevelService.emptyMethod1(params);
        return ResponseEx.createSuccess("成功");
	}

}
