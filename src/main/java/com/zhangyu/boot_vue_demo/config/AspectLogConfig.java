package com.zhangyu.boot_vue_demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2019/9/16 15:51
 * @since JDK 1.8
 */
@Component
@Aspect
public class AspectLogConfig {

    private static final Logger log = LoggerFactory.getLogger(AspectLogConfig.class);

    @Pointcut("execution(* com.zhangyu.boot_vue_demo.controller.*.*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Exception {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("请求类型 : " + request.getMethod());
        log.info("请求IP : " + request.getRemoteAddr());
        log.info("方法 : " + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        log.info("参数列表 : " + Arrays.toString(point.getArgs()));
        long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            log.error("发生了异常！" + throwable);
            throwable.printStackTrace();
            throw  new Exception();
        }
        log.info("返回值：" + proceed);
        log.info("耗时："+ (System.currentTimeMillis() - start) +" 毫秒!");
        return proceed;
    }
}
