package com.bowensun.film.service.impl;

import com.bowensun.film.domain.LoginUser;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.service.LoginService;
import com.bowensun.film.service.UserService;
import com.bowensun.film.service.component.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenService tokenService;

    @Resource
    private UserService userService;

    @Override
    public String login(String username, String password){
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (Exception e){
            if (e instanceof InternalAuthenticationServiceException){
                log.info("用户：{} 认证失败", username);
                //TODO 异步处理 记录日志
            }
            throw e;
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }

    @Override
    public void register(UserDTO user) {
        reEncrypt(user);
        userService.insert(user);
    }

    private void reEncrypt(UserDTO user) {
        String encode = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encode);
    }
}
