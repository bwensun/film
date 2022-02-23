package com.bowensun.film.common.config;

import com.bowensun.film.service.component.AuthenticationEntryPointImpl;
import com.bowensun.film.service.component.JwtAuthenticationTokenFilter;
import com.bowensun.film.service.component.LogoutSuccessHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

/**
 * spring security 配置
 *
 * @author 郑建雄
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private AuthenticationEntryPointImpl unauthorizedHandler;

    @Resource
    private LogoutSuccessHandlerImpl logoutSuccessHandler;

    @Resource
    private JwtAuthenticationTokenFilter authenticationTokenFilter;

    @Resource
    private CorsFilter corsFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                // 无需授权均可访问的接口:登录、注册、验证码获取、电影分页查询、排行、字典
                .antMatchers("/login", "/register", "/captcha/**", "/film/page", "/user/userInfo", "/rank/activity", "/system/dict/all", "/system/dict/info", "/test/**").permitAll()
                .antMatchers(HttpMethod.GET, "/*.html", "/**/*.html", "/**/*.css", "/**/*.js").permitAll()
                .antMatchers("/druid/**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated().and()
                .headers().frameOptions().disable();
        http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
                //禁用跨站请求伪造 防止Postman失败
//        .and().csrf().ignoringAntMatchers("/user/**");
        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 添加CORS filter
        http.addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/doc.html",
                // swagger api json
                "/v2/api-docs",
                "/swagger-resources/**",
                //补充路径，近期在搭建swagger接口文档时，通过浏览器控制台发现该/webjars路径下的文件被拦截，故加上此过滤条件即可。(2020-10-23)
                "/webjars/**"
        );
    }
}