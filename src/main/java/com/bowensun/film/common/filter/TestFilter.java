package com.bowensun.film.common.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/4/10
 */
//@WebFilter(urlPatterns = "/*", filterName = "testFilter")
public class TestFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        //logger.info("==========初始化过滤器=============");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //logger.info("==========开始过滤=============");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //logger.info("==========销毁过滤器=============");
    }
}
