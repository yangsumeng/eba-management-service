
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
import com.ebei.eba.model.entity.ParamDetail;
import com.ebei.eba.service.ParamDetailService;


/** auto code version 1.4
 * <p>
 * 设备属性详情 前端控制器
 * </p>
 * @author JiangP
 * @since 2018-09-10
 */
@RestController
@RequestMapping("/paramDetail")
@Api(value = "paramDetail" , description = "设备属性详情")
public class ParamDetailController {
	@Autowired
	private ParamDetailService paramDetailService;

	/**自动生成 2018-09-10*/
	@ApiOperation(value = "按照paramDetailID获取详情", notes = "获取paramDetail详细信息")
	@ApiImplicitParam(name = "paramDetailId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/byId/{paramDetailId}")
	public ResponseEx<ParamDetail> getById(@PathVariable String paramDetailId) {

		ParamDetail paramDetail = paramDetailService.selectById(paramDetailId);
        return ResponseEx.createSuccess(paramDetail);
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
			Page<Map<String,Object>> page = paramDetailService.selectMapList(new Page<>(pageIndex, pageSize), params);
			result =  ResponsePageEx.createSuccess(page, page.getTotal(), page.getCurrent(), page.getSize(), page.getPages());
        }
		return result;
	}

	/**自动生成 2018-09-10*/
	@ApiOperation(value="新增paramDetail")
	@PostMapping("/saveParamDetail")
	public ResponseEx<Object> saveParamDetail(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) ParamDetail paramDetail, @RequestHeader HttpHeaders headers) {
		//String userAccount = headers.getFirst(Constants.USER_HEADER);
		paramDetail.setCreator(paramDetail.getOperator());
		paramDetail.setOperateDate(new Date());
		paramDetail.setCreateDate(new Date());
		paramDetail.setState(Constance.STATE_YES);
		boolean result = paramDetailService.insert(paramDetail);
		if (!result) {
			return ResponseEx.createError("新增失败");
		}
		return ResponseEx.createSuccess("success");
	}
	
	@ApiOperation(value="编辑paramDetail")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "paramDetailId", value = "URL参数：paramDetailID", required = true)
	})
	@PostMapping("/editParamDetail/{paramDetailId}")
	public ResponseEx<Object> editParamDetail(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) ParamDetail paramDetail, @PathVariable String paramDetailId, @RequestHeader HttpHeaders headers) {
		// 设置主键ID
        //String userAccount = headers.getFirst(Constants.USER_HEADER);
		paramDetail.setDetailId(String.valueOf(paramDetailId));
		paramDetail.setOperateDate(new Date());
		boolean result = paramDetailService.updateById(paramDetail);
        if (!result) {
        	return ResponseEx.createError("修改失败");
        }
        return ResponseEx.createSuccess("success");
	}

	/**自动生成 2018-09-10*/
	@ApiOperation(value = "通过主键ID逻辑删除", notes = "逻辑删除设备属性详情实体")
	@ApiImplicitParam(name = "paramDetailId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/deleteById/{paramDetailId}")
	public ResponseEx<Object> deleteById(@PathVariable String paramDetailId) {
        boolean ok = paramDetailService.deleteById(String.valueOf(paramDetailId));
        if(!ok){
        	return ResponseEx.createError("删除失败");
        }
        return ResponseEx.createSuccess("删除成功");
     }

    /**自动生成 2018-09-10 */
    @ApiOperation(value = "获取设备属性详情页面选择框数据", notes = "获取设备属性详情页面选择框数据")
    @PostMapping("/getLabelAndValueList")
    public ResponseEx<Object> getLabelAndValueList(@RequestBody @ApiParam(name="params",value="无参请传{}")  Map<String,Object> params) {
		List<Map<String,Object>> list = paramDetailService.getLabelAndValueList(params);
		return ResponseEx.createSuccess(list);
	}


	/**自动生成 2018-09-10 */
	@ApiOperation(value = "emptyMethod1 方法")
	@GetMapping("/emptyMethod1")
	public ResponseEx<Object> emptyMethod1(){
        Map<String,Object> params = null;
	    Object result = paramDetailService.emptyMethod1(params);
        return ResponseEx.createSuccess("成功");
	}

}
