package com.zhangyu.boot_vue_demo.config;

import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

/**
 * Function: Gson配置类。Spring Boot会提供一个GsonHttpMessageConverter，所以没必要实现WebMvcConfigurer
 *           如果使用阿里巴巴的FastJson，则需要实现自己的converter，实现WebMvcConfigurer中的configureMessageConverter方法
 *
 * @author zhangyu
 * Date: 2019/9/12 17:49
 * @since JDK 1.8
 */
@Configuration
public class GsonConfig {

    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter(){
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        GsonBuilder builder = new GsonBuilder();

        builder
                // 设置日期格式
                .setDateFormat("yyyy-MM-dd")
                // 解析是将protected的字段过滤掉
                .excludeFieldsWithModifiers(Modifier.PROTECTED);
        converter.setGson(builder.create());
        return converter;
    }


}
