package com.bowensun.film.service.impl;

import com.bowensun.film.common.config.redis.RedisCache;
import com.bowensun.film.common.exception.BizException;
import com.bowensun.film.domain.LoginUser;
import com.bowensun.film.service.LoginService;
import com.bowensun.film.service.component.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 登录服务实现
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private RedisCache redisCache;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenService tokenService;

    @Override
    public String login(String username, String password){
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (Exception e){
            if (e instanceof BadCredentialsException){
                log.info("用户：{} 认证失败", username);
                //TODO: 异步插入日志表
                throw BizException.of("-1", "用户名或密码错误");
            }else {
                throw BizException.of("-1", e.getMessage());
            }
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }
}
