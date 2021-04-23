package com.bowensun.film.web;

import com.bowensun.film.domain.base.Result;
import com.bowensun.film.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 登陆控制器
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("login")
    public Result<String> login(String username, String password){
        String token = loginService.login(username, password);
        return  Result.success(token);
    }
}
