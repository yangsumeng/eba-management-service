
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
import com.ebei.eba.model.entity.WarningMsg;
import com.ebei.eba.service.WarningMsgService;


/** auto code version 1.4
 * <p>
 * 告警消息模板 前端控制器
 * </p>
 * @author JiangP
 * @since 2018-09-10
 */
@RestController
@RequestMapping("/warningMsg")
@Api(value = "warningMsg" , description = "告警消息模板")
public class WarningMsgController {
	@Autowired
	private WarningMsgService warningMsgService;

	/**自动生成 2018-09-10*/
	@ApiOperation(value = "按照warningMsgID获取详情", notes = "获取warningMsg详细信息")
	@ApiImplicitParam(name = "warningMsgId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/byId/{warningMsgId}")
	public ResponseEx<WarningMsg> getById(@PathVariable String warningMsgId) {

		WarningMsg warningMsg = warningMsgService.selectById(warningMsgId);
        return ResponseEx.createSuccess(warningMsg);
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
			Page<Map<String,Object>> page = warningMsgService.selectMapList(new Page<>(pageIndex, pageSize), params);
			result =  ResponsePageEx.createSuccess(page, page.getTotal(), page.getCurrent(), page.getSize(), page.getPages());
        }
		return result;
	}

	/**自动生成 2018-09-10*/
	@ApiOperation(value="新增warningMsg")
	@PostMapping("/saveWarningMsg")
	public ResponseEx<Object> saveWarningMsg(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) WarningMsg warningMsg, @RequestHeader HttpHeaders headers) {
		//String userAccount = headers.getFirst(Constants.USER_HEADER);
		warningMsg.setCreator(warningMsg.getOperator());
		warningMsg.setOperateDate(new Date());
		warningMsg.setCreateDate(new Date());
		warningMsg.setState(Constance.STATE_YES);
		boolean result = warningMsgService.insert(warningMsg);
		if (!result) {
			return ResponseEx.createError("新增失败");
		}
		return ResponseEx.createSuccess("success");
	}
	
	@ApiOperation(value="编辑warningMsg")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "warningMsgId", value = "URL参数：warningMsgID", required = true)
	})
	@PostMapping("/editWarningMsg/{warningMsgId}")
	public ResponseEx<Object> editWarningMsg(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) WarningMsg warningMsg, @PathVariable String warningMsgId, @RequestHeader HttpHeaders headers) {
		// 设置主键ID
        //String userAccount = headers.getFirst(Constants.USER_HEADER);
		warningMsg.setMessageId(Long.valueOf(warningMsgId));
		warningMsg.setOperateDate(new Date());
		boolean result = warningMsgService.updateById(warningMsg);
        if (!result) {
        	return ResponseEx.createError("修改失败");
        }
        return ResponseEx.createSuccess("success");
	}

	/**自动生成 2018-09-10*/
	@ApiOperation(value = "通过主键ID逻辑删除", notes = "逻辑删除告警消息模板实体")
	@ApiImplicitParam(name = "warningMsgId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/deleteById/{warningMsgId}")
	public ResponseEx<Object> deleteById(@PathVariable String warningMsgId) {
        boolean ok = warningMsgService.deleteById(Long.valueOf(warningMsgId));
        if(!ok){
        	return ResponseEx.createError("删除失败");
        }
        return ResponseEx.createSuccess("删除成功");
     }

    /**自动生成 2018-09-10 */
    @ApiOperation(value = "获取告警消息模板页面选择框数据", notes = "获取告警消息模板页面选择框数据")
    @PostMapping("/getLabelAndValueList")
    public ResponseEx<Object> getLabelAndValueList(@RequestBody @ApiParam(name="params",value="无参请传{}")  Map<String,Object> params) {
		List<Map<String,Object>> list = warningMsgService.getLabelAndValueList(params);
		return ResponseEx.createSuccess(list);
	}


	/**自动生成 2018-09-10 */
	@ApiOperation(value = "emptyMethod1 方法")
	@GetMapping("/emptyMethod1")
	public ResponseEx<Object> emptyMethod1(){
        Map<String,Object> params = null;
	    Object result = warningMsgService.emptyMethod1(params);
        return ResponseEx.createSuccess("成功");
	}
}
