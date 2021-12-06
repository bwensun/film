package com.bowensun.film.common.config;

import com.bowensun.film.common.interceptor.TestInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author 郑建雄
 * @date 2019/4/10
 */
@Configuration
public class FilmWebMvcConfig extends WebMvcConfigurationSupport {


    /**
     * 拦截器
     *
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");

    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //string消息转换器
        converters.add(stringHttpMessageConverter());
        //
        super.extendMessageConverters(converters);
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){
        final StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
        return stringHttpMessageConverter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        final ObjectMapper objectMapper = new ObjectMapper();
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}
