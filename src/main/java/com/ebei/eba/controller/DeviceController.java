
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
import com.ebei.eba.model.entity.Device;
import com.ebei.eba.service.DeviceService;


/** auto code version 1.4
 * <p>
 * 设备表 前端控制器
 * </p>
 * @author JiangP
 * @since 2018-09-10
 */
@RestController
@RequestMapping("/device")
@Api(value = "device" , description = "设备表")
public class DeviceController {
	@Autowired
	private DeviceService deviceService;

	/**自动生成 2018-09-10*/
	@ApiOperation(value = "按照deviceID获取详情", notes = "获取device详细信息")
	@ApiImplicitParam(name = "deviceId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/byId/{deviceId}")
	public ResponseEx<Device> getById(@PathVariable String deviceId) {

		Device device = deviceService.selectById(deviceId);
        return ResponseEx.createSuccess(device);
	}

	/**自动生成 2018-09-10*/
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
			Page<Map<String,Object>> page = deviceService.selectMapList(new Page<>(pageIndex, pageSize), params);
			result =  ResponsePageEx.createSuccess(page, page.getTotal(), page.getCurrent(), page.getSize(), page.getPages());
        }
		return result;
	}

	/**自动生成 2018-09-10*/
	@ApiOperation(value="新增device")
	@PostMapping("/saveDevice")
	public ResponseEx<Object> saveDevice(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) Device device, @RequestHeader HttpHeaders headers) {
		//String userAccount = headers.getFirst(Constants.USER_HEADER);
		device.setCreator(device.getOperator());
		device.setOperateDate(new Date());
		device.setCreateDate(new Date());
		device.setState(Constance.STATE_YES);
		boolean result = deviceService.insert(device);
		if (!result) {
			return ResponseEx.createError("新增失败");
		}
		return ResponseEx.createSuccess("success");
	}
	
	@ApiOperation(value="编辑device")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "deviceId", value = "URL参数：deviceID", required = true)
	})
	@PostMapping("/editDevice/{deviceId}")
	public ResponseEx<Object> editDevice(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) Device device, @PathVariable String deviceId, @RequestHeader HttpHeaders headers) {
		// 设置主键ID
        //String userAccount = headers.getFirst(Constants.USER_HEADER);
		device.setDeviceId(String.valueOf(deviceId));
		device.setOperateDate(new Date());
		boolean result = deviceService.updateById(device);
        if (!result) {
        	return ResponseEx.createError("修改失败");
        }
        return ResponseEx.createSuccess("success");
	}

	/**自动生成 2018-09-10*/
	@ApiOperation(value = "通过主键ID逻辑删除", notes = "逻辑删除设备表实体")
	@ApiImplicitParam(name = "deviceId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/deleteById/{deviceId}")
	public ResponseEx<Object> deleteById(@PathVariable String deviceId) {
        boolean ok = deviceService.deleteById(String.valueOf(deviceId));
        if(!ok){
        	return ResponseEx.createError("删除失败");
        }
        return ResponseEx.createSuccess("删除成功");
     }

    /**自动生成 2018-09-10 */
    @ApiOperation(value = "获取设备表页面选择框数据", notes = "获取设备表页面选择框数据")
    @PostMapping("/getLabelAndValueList")
    public ResponseEx<Object> getLabelAndValueList(@RequestBody @ApiParam(name="params",value="无参请传{}")  Map<String,Object> params) {
		List<Map<String,Object>> list = deviceService.getLabelAndValueList(params);
		return ResponseEx.createSuccess(list);
	}


	/**自动生成 2018-09-10 */
	@ApiOperation(value = "emptyMethod1 方法")
	@GetMapping("/emptyMethod1")
	public ResponseEx<Object> emptyMethod1(){
        Map<String,Object> params = null;
	    Object result = deviceService.emptyMethod1(params);
        return ResponseEx.createSuccess("成功");
	}

	/**自动生成 2018-09-10 */
	@ApiOperation(value = "emptyMethod2 方法")
	@GetMapping("/emptyMethod2")
	public ResponseEx<Object> emptyMethod2(){
        Map<String,Object> params = null;
	    Object result = deviceService.emptyMethod2(params);
        return ResponseEx.createSuccess("成功");
	}

}
