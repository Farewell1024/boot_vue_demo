package com.zhangyu.boot_vue_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Function: web app config
 *
 * @author zhangyu
 * Date: 2019/9/16 12:06
 * @since JDK 1.8
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.
                addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("GET","POST","OPTIONS")
                .maxAge(1800)
                .allowedOrigins("*");
    }
}
