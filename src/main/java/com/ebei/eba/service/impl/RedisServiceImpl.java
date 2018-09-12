package com.ebei.eba.service.impl;

import com.ebei.eba.common.constant.Constance;
import com.ebei.eba.dao.RedisDao;
import com.ebei.eba.service.RedisService;
import com.ebei.eba.vo.RedisParams;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 
 * @Description : redis service实现层
 * @time 创建时间 : 2018/08/15
 * @author : Victor.You@ebeitech
 * @Copyright (c) 2018 一碑科技
 * @version
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {
    /**
     * 日志句柄
     */
    private static Logger logger = Logger.getLogger(RedisServiceImpl.class);

    private int tokenDbIndex = 0;
    
    @Resource
    private RedisDao redisDao;

    @Override
    public void save(RedisParams params) throws IOException {
        if(null == params){
            return ;
        }

        this.redisDao.save(params, Constance.REDIS_DEFAULT_EXPIRE_TIME);
    }

    @Override
    public Object read(RedisParams redisParams){
        Object object = this.redisDao.read(redisParams);

        if(null == object){
            return null;
        }

        return object;
    }

    @Override
    public void delete(RedisParams params) {
        this.redisDao.delete(params);
    }
}
