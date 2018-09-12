package com.ebei.eba.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Auther: yangsm
 * @Date: 2018/9/11 0011
 */
@Configuration
public class RestTemplateConfig {

    /**RPC声明*/
    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(10000);
        requestFactory.setConnectTimeout(10000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        // 使用 utf-8 编码集的 conver 替换默认的 conver（默认的 string conver 的编码集为 "ISO-8859-1"）
        List<HttpMessageConverter<?>> messageConverters = Lists.newArrayList();
        Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();
        while (iterator.hasNext()) {
            HttpMessageConverter<?> converter = iterator.next();
            if (converter instanceof StringHttpMessageConverter) {
                iterator.remove();
            }
        }
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
