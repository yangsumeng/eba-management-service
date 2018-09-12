
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
import com.ebei.eba.model.entity.LevelParam;
import com.ebei.eba.service.LevelParamService;


/** auto code version 1.4
 * <p>
 * 级别参数 前端控制器
 * </p>
 * @author JiangP
 * @since 2018-09-03
 */
@RestController
@RequestMapping("/levelParam")
@Api(value = "levelParam" , description = "级别参数")
public class LevelParamController {
	@Autowired
	private LevelParamService levelParamService;

	/**自动生成 2018-09-03*/
	@ApiOperation(value = "按照levelParamID获取详情", notes = "获取levelParam详细信息")
	@ApiImplicitParam(name = "levelParamId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/byId/{levelParamId}")
	public ResponseEx<LevelParam> getById(@PathVariable String levelParamId) {

		LevelParam levelParam = levelParamService.selectById(levelParamId);
        return ResponseEx.createSuccess(levelParam);
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
			Page<Map<String,Object>> page = levelParamService.selectMapList(new Page<>(pageIndex, pageSize), params);
			result =  ResponsePageEx.createSuccess(page, page.getTotal(), page.getCurrent(), page.getSize(), page.getPages());
        }
		return result;
	}

	/**自动生成 2018-09-03*/
	@ApiOperation(value="新增levelParam")
	@PostMapping("/saveLevelParam")
	public ResponseEx<Object> saveLevelParam(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) LevelParam levelParam, @RequestHeader HttpHeaders headers) {
		//String userAccount = headers.getFirst(Constants.USER_HEADER);
		levelParam.setCreator(levelParam.getOperator());
		levelParam.setOperateDate(new Date());
		levelParam.setCreateDate(new Date());
		levelParam.setState(Constance.STATE_YES);
		boolean result = levelParamService.insert(levelParam);
		if (!result) {
			return ResponseEx.createError("新增失败");
		}
		return ResponseEx.createSuccess("success");
	}
	
	@ApiOperation(value="编辑levelParam")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "levelParamId", value = "URL参数：levelParamID", required = true)
	})
	@PostMapping("/editLevelParam/{levelParamId}")
	public ResponseEx<Object> editLevelParam(@RequestBody @ApiParam(name="param",value="参数JSON",required=true) LevelParam levelParam, @PathVariable String levelParamId, @RequestHeader HttpHeaders headers) {
		// 设置主键ID
        //String userAccount = headers.getFirst(Constants.USER_HEADER);
		levelParam.setParamId(Long.valueOf(levelParamId));
		levelParam.setOperateDate(new Date());
		boolean result = levelParamService.updateById(levelParam);
        if (!result) {
        	return ResponseEx.createError("修改失败");
        }
        return ResponseEx.createSuccess("success");
	}

	/**自动生成 2018-09-03*/
	@ApiOperation(value = "通过主键ID逻辑删除", notes = "逻辑删除级别参数实体")
	@ApiImplicitParam(name = "levelParamId", value = "主键ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/deleteById/{levelParamId}")
	public ResponseEx<Object> deleteById(@PathVariable String levelParamId) {
        boolean ok = levelParamService.deleteById(Long.valueOf(levelParamId));
        if(!ok){
        	return ResponseEx.createError("删除失败");
        }
        return ResponseEx.createSuccess("删除成功");
     }

    /**自动生成 2018-09-03 */
    @ApiOperation(value = "获取级别参数页面选择框数据", notes = "获取级别参数页面选择框数据")
    @PostMapping("/getLabelAndValueList")
    public ResponseEx<Object> getLabelAndValueList(@RequestBody @ApiParam(name="params",value="无参请传{}")  Map<String,Object> params) {
		List<Map<String,Object>> list = levelParamService.getLabelAndValueList(params);
		return ResponseEx.createSuccess(list);
	}


	/**自动生成 2018-09-03 */
	@ApiOperation(value = "emptyMethod1 方法")
	@GetMapping("/emptyMethod1")
	public ResponseEx<Object> emptyMethod1(){
        Map<String,Object> params = null;
	    Object result = levelParamService.emptyMethod1(params);
        return ResponseEx.createSuccess("成功");
	}

	/**自动生成 2018-09-03 */
	@ApiOperation(value = "emptyMethod2 方法")
	@GetMapping("/emptyMethod2")
	public ResponseEx<Object> emptyMethod2(){
        Map<String,Object> params = null;
	    Object result = levelParamService.emptyMethod2(params);
        return ResponseEx.createSuccess("成功");
	}
	
	// TODO 新增级别参数绑定key值
	

}
