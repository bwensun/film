package com.bowensun.film.common.aop;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Objects;
import java.util.Optional;

/**
 * 日志切面
 *
 * @author 郑建雄
 * @date 2022/1/10
 */
@Aspect
@Component
@Slf4j
public class LogAop {

    @Pointcut("execution(* com.bowensun.film.web.*.*(..))")
    public void doPointCut() {
    }

    @SneakyThrows
    @Around("doPointCut()")
    public Object aroundExecute(ProceedingJoinPoint point) {
        long startTime = System.currentTimeMillis();
        //切面前处理
        doLogBefore(point);
        Object proceed;
        proceed = point.proceed();
        //切面后处理
        doLogAfter(proceed);
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        log.info("========================================== End ==========================================");
        return proceed;
    }


    private void doLogBefore(ProceedingJoinPoint point) {
        HttpServletRequest request = Optional
                .of((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .map(ServletRequestAttributes::getRequest)
                .orElse(null);
        //参数预处理
        preProcess(point);
        // 打印请求相关参数
        log.info("========================================== Start ==========================================");
        Assert.notNull(request, "request不可为null");
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        log.info("Request Args   : {}", JSON.toJSONString(point.getArgs()));
    }

    private void preProcess(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        if (null == args || args.length == 0) {
            log.info("Request Args   : 无参数，不打印");
        }
        for (int i = 0; i < Objects.requireNonNull(args).length; i++) {
            if (args[i] instanceof MultipartFile || args[i] instanceof File) {
                args[i] = "上传文件不打印";
            }
            if (args[i] instanceof HttpServletResponse) {
                args[i] = "响应头不打印";
            }
            if (args[i] instanceof HttpServletRequest) {
                args[i] = "请求头不打印";
            }
        }
    }


    private void doLogAfter(Object proceed) {
        // 打印出参
        log.info("Response Args  : {}", JSON.toJSONString(proceed));
    }
}
