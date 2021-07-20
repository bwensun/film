package com.bowensun.film.common.config;

import cn.hutool.http.HttpStatus;
import com.bowensun.film.common.constant.ExceptionEnum;
import com.bowensun.film.common.constant.ExceptionTypeEnum;
import com.bowensun.film.common.exception.BizException;
import com.bowensun.film.domain.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.bowensun.film.common.constant.ExceptionTypeEnum.AUTH_EXCEPTION;

/**
 * 全局异常处理
 *
 * @author 郑建雄
 * @date 2021/3/12
 */
@Slf4j
@ControllerAdvice
@Order(Integer.MIN_VALUE)
public class GatewayGlobalExceptionHandler {


    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Result<?> businessException(HttpServletRequest request, BizException e) {
        handlerException(ExceptionTypeEnum.BIZ_EXCEPTION.desc, request, e);
        return Result.error(e.code, e.message);
    }

    @ExceptionHandler(AuthenticationServiceException.class)
    @ResponseBody
    public Result<?> businessException(HttpServletRequest request, AuthenticationServiceException e) {
        handlerException(AUTH_EXCEPTION.desc, request, e);
        return Result.error(ExceptionEnum.AUTH_EXCEPTION.code, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<?> otherException(HttpServletRequest request, Exception e) {
        handlerException(ExceptionTypeEnum.OTHER_EXCEPTION.desc, request, e);
        return Result.error("内部服务器错误", String.valueOf(HttpStatus.HTTP_INTERNAL_ERROR));
    }

    /**
     * 打印下日志
     */
    private void handlerException(String exceptionType, HttpServletRequest request, Exception e) {
        log.error("【{}】 请求路径：{}", exceptionType, request.getRequestURL(), e);
    }
}
