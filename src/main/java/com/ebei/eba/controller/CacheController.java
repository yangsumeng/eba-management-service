package com.ebei.eba.controller;

import com.ebei.eba.common.util.ResponseEx;
import com.ebei.eba.service.RedisService;
import com.ebei.eba.vo.RedisParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 换存测试
 *
 */

@RestController
@RequestMapping("/cache")
@Api(value = "cache" , description = "redis测试")
public class CacheController {
    
    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "读取", notes = "读取")
    @PostMapping("/read")
    public ResponseEx<Object> read(@RequestBody RedisParams redisParams) {
        Object value = redisService.read(redisParams);
        if (value != null) {
            return ResponseEx.createError("错误");
        }
        return ResponseEx.createSuccess(10200, "成功");
    }

    @ApiOperation(value = "删除", notes = "删除")
    @PostMapping("/delete")
    public ResponseEx<String> delete(@RequestBody RedisParams redisParams) {
        redisService.delete(redisParams);
        return ResponseEx.createSuccess(10200, "成功");
    }

    @ApiOperation(value = "保存", notes = "保存")
    @PostMapping("/save")
    public ResponseEx<Object> save(@RequestBody RedisParams redisParams) throws IOException {
        redisService.save(redisParams);
        return ResponseEx.createSuccess("成功");
    }

}
