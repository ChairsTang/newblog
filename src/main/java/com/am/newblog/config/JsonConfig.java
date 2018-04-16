package com.am.newblog.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AMan
 * @Date 2017/12/25 18:58
 */
@Configuration
public class JsonConfig {
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        //定义一个消息解析对象
        FastJsonHttpMessageConverter fastJsonMessageConverter = new FastJsonHttpMessageConverter();

        //FastJson配置,是否格式化
        FastJsonConfig jsonConfig = new FastJsonConfig();

        jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        fastJsonMessageConverter.setFastJsonConfig(jsonConfig);

        //处理中文乱码
        List<MediaType> fastJsonMediaTypeList = new ArrayList<>();

        fastJsonMediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);

        fastJsonMessageConverter.setSupportedMediaTypes(fastJsonMediaTypeList);

        HttpMessageConverter<?> converter = fastJsonMessageConverter;

        return new HttpMessageConverters(converter);
    }
}
