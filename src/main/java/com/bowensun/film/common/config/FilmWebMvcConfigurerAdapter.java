package com.bowensun.film.common.config;

import com.bowensun.film.common.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/4/10
 */
@Configuration
public class FilmWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
                //.excludePathPatterns("/toLogin","/login");
        super.addInterceptors(registry);
    }
}
