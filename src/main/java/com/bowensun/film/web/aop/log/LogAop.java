package com.bowensun.film.web.aop.log;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 * @author 郑建雄
 * @program film
 * @description 日志切面类
 * @date 2019/4/2
 */
@Aspect
@Component
public class LogAop {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(LogT)")
    public void log(){

    }

    @Around("log()")
    public Object aroundExecute(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String contentType = request.getContentType();

        Object[] args = point.getArgs();
        String methodName = point.toShortString();
        logger.info("===========>开始调用:"+ methodName +"<================");
        Object result = point.proceed();
        long end = System.currentTimeMillis();
        long costTime = end - start;
        logger.info("方法名:"+ methodName + "  请求用时："+ costTime + "ms  参数:" + JSON.toJSON(args) + "  响应结果: " + JSON.toJSON(result));
        logger.info("===========>结束调用:"+ methodName +"<================");
        return result;
    }
}
