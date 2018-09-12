package com.ebei.eba.common.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 分类service接口
 * Created by wufq on 2018/5/11.
 */

@Component
@Order(1)
public class CacheDataRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CacheDataRunner.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 初始化
     * @param args args
     * @throws Exception e
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("11 11 11 11 11 11 11         11 11 11 11 11 11 11                 11");
        logger.info("11                           11                11               11  11");
        logger.info("11                           11                11             11      11");
        logger.info("11 11 11 11 11 11 11         11 11 11 11 11 11 11           11 11 11 11 11");
        logger.info("11                           11                11         11              11");
        logger.info("11                           11                11       11                  11");
        logger.info("11 11 11 11 11 11 11         11 11 11 11 11 11 11     11                      11");
        logger.info("=========================================================    EBA系统启动成功 EBA START SUCCESS");
    }
}
