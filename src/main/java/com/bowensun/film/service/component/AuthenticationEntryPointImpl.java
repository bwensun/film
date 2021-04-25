package com.bowensun.film.service.component;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.bowensun.film.common.util.ServletUtils;
import com.bowensun.film.domain.base.Result;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证失败处理器
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        String msg = StrUtil.format("请求访问：{}， 认证失败，无法访问服务器资源", request.getRequestURI());
        String code = String.valueOf(HttpStatus.UNAUTHORIZED.value());
        ServletUtils.renderString(response, JSON.toJSONString(Result.error(msg, code)));
    }
}
