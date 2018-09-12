package com.ebei.eba.dao;


import com.ebei.eba.vo.RedisParams;

public interface RedisDao {
    void save(RedisParams params, int expirTime);
    
    void save(RedisParams params);
    
    Object read(RedisParams params);
    
    void delete(RedisParams params);
}
