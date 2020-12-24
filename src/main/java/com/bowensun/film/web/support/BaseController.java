package com.bowensun.film.web.support;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;


/**
 * @author 郑建雄
 */
@ControllerAdvice
@CrossOrigin
public class BaseController {



    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    public String handleException(Exception e, HttpServletRequest request) {
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        String error = "";
        Result result = null;
        if (e instanceof ServiceException) {
            errorCode = ((ServiceException) e).errorCode;
            result = new Error(errorCode.code, errorCode.message);
        } else {
            result = new Error(errorCode.code, errorCode.message);
        }
        logger.info("接口：{}异常，异常状态码：{}，异常信息：{}", request.getRequestURI(), errorCode.code, e);
        ObjectMapper ObjectMapper = new ObjectMapper();
        try {
            error = ObjectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        return error;
    }
}
