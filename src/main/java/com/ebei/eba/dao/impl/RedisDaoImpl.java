package com.ebei.eba.dao.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ebei.eba.common.constant.Constance;
import com.ebei.eba.dao.RedisDao;
import com.ebei.eba.vo.RedisParams;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository("redisDao")
public class RedisDaoImpl implements RedisDao {
	@Autowired
	protected StringRedisTemplate redisTemplate;

	@Override
	public void save(RedisParams params, final int expireTime) {
		switch (params.getType()) {
            case Constance.REDIS_TYPE_STRING:
                redisTemplate.opsForValue().set((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey(), params.getValue().toString(), expireTime, TimeUnit.SECONDS);
                break;
            case Constance.REDIS_TYPE_HASH:
                redisTemplate.opsForHash().put((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey(), params.getField(), params.getValue().toString());
                break;
            case Constance.REDIS_TYPE_LIST:
                redisTemplate.opsForList().leftPush((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey(), params.getValue().toString());
                break;
            case Constance.REDIS_TYPE_SET:
                redisTemplate.opsForSet().add((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey(), params.getValue().toString());
                break;
            case Constance.REDIS_TYPE_ZSET:
                redisTemplate.opsForZSet().add((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey(), params.getValue().toString(), params.getScore());
                break;
        }
	}

	@Override
	public void save(RedisParams params) {
	    this.save(params, Constance.REDIS_DEFAULT_EXPIRE_TIME);
	}

	@Override
	public Object read(RedisParams params) {
        Object value = null;
        switch (params.getType()) {
            case Constance.REDIS_TYPE_STRING:
                System.out.println((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey());
                value = redisTemplate.opsForValue().get((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey());
                break;
            case Constance.REDIS_TYPE_HASH:
                if (StringUtils.isEmpty(params.getField())) {
                    value = redisTemplate.opsForHash().values((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey());
                } else {
                    value = redisTemplate.opsForHash().get((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey(),params.getField());
                }
                break;
            case Constance.REDIS_TYPE_LIST:
                value = redisTemplate.opsForList().range((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey(), 0, redisTemplate.opsForList().size((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey()));
                break;
            case Constance.REDIS_TYPE_SET:
                value = redisTemplate.opsForSet().members((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey());
                break;
            case Constance.REDIS_TYPE_ZSET:
                value = redisTemplate.opsForZSet().range((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey(), 0, redisTemplate.opsForZSet().size((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey()));
                break;
        }
		if (value == null) {
			return null;
		} else {
		    if (value instanceof String) {
		        try {
		            value = JSONObject.parseObject((String) value);
                } catch (Exception e) {
                }
            }
            if (value instanceof List) {
                try {
                    value = JSONArray.parseArray(value.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (value instanceof Set) {
                try {
                    value = JSONArray.parseArray(value.toString());
                } catch (Exception e) {
                }
            }
        }
		return value;
	}

	@Override
	public void delete(RedisParams params)
	{
		redisTemplate.delete((StringUtils.isEmpty(params.getNamespace())?"":(params.getNamespace() + ":")) + params.getKey());
	}


}
