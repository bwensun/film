package com.bowensun.film.common.aop;

import com.bowensun.film.common.annotation.LogT;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志织入逻辑
 *
 * @author 郑建雄
 * @date 2021/3/12
 */
@Aspect
@Component
public class LogAop {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.bowensun.film.common.annotation.LogT)")
    public void log() {

    }

    @SneakyThrows
    @Around("log()")
    public Object aroundExecute(ProceedingJoinPoint point){
        long start = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LogT logT = method.getAnnotation(LogT.class);
        String functionName = logT.functionName();
        logger.info("==========>开始执行{}<==========", functionName);
        Object[] args = point.getArgs();
        logger.info("【{}】 参数列表{}", functionName, args);
        Object result = point.proceed();
        long end = System.currentTimeMillis();
        long costTime = end - start;
        logger.info("==========>结束执行{}, 耗时{}ms<==========", functionName, costTime);
        return result;
    }
}
