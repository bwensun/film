package com.bowensun.film.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/4/10
 */
public class TestInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理器执行之前调用
     *
     * @param request  HttpServletRequest对象，可以获取请求参数等等
     * @param response HttpServletResponse对象
     * @param Handler  拦截器的Controller对象
     * @return 如果返回false，就会中断处理流程，不会处理后续的拦截器和Controller。如果返回true，则会执行后续的拦截器和处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
        //logger.info("=========处理器执行之前调用==========");
        String url = request.getRequestURL().toString();
        String servletPath = request.getServletPath();
        return true;
    }

    /**
     * 处理器执行之后调用,跳转到指定视图之前调用
     *
     * @param request      HttpServletRequest对象
     * @param response     HttpServletResponse对象
     * @param handler      拦截器的Controller对象
     * @param modelAndView ModelAndView对象，其中存放的是处理结果和视图的信息
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //logger.info("=========处理器执行之后调用,跳转到指定视图之前调用==========");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
        //logger.info("=========请求处理完成之后调用===========");
    }
}
