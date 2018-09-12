package com.ebei.eba.service;


import com.ebei.eba.vo.RedisParams;

import java.io.IOException;

/**
 * 
 * @Description :redis service
 * @time 2018/08/15
 * @author : Victor.You@ebeitech
 * @Copyright (c) 2018 一碑科技
 * @version
 */
public interface RedisService {
    void save(RedisParams params) throws IOException;

    Object read(RedisParams params);

    void delete(RedisParams params);
}
