package com.bowensun.film.common.shiro;

import com.alibaba.fastjson.JSONObject;
import com.bowensun.film.domain.Account;
import com.bowensun.film.domain.UserInfo;
import com.bowensun.film.service.UserInfoService;
import com.bowensun.film.web.support.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author bowensun
 * @date 2018/11/3
 */
@RestController
@Slf4j
@RequestMapping("userInfo")
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    //登录
    @ApiIgnore
    @PostMapping("/login")
    public Result login(String username, String password, boolean rememberMe) {
        log.info("-------进入登录方法-------");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject currentUser = SecurityUtils.getSubject();
        JSONObject jsonObject = new JSONObject();
        //登录
        try {
            currentUser.login(token);
            jsonObject.put("token", currentUser.getSession().getId());
        } catch (IncorrectCredentialsException e) {
            throw new ServiceException(ErrorCode.PASSWORD_NOT_CORRECT);
        }
        UserInfo userInfo = (UserInfo) currentUser.getPrincipal();
        return new Success(userInfo);
    }

    //注册用户
    @ApiIgnore
    @RequestMapping(value = "/add")
    @RequiresPermissions("admin:add")
    public String register(Model model) {
        log.info("------进入注册方法----");
        model.addAttribute("value", "新增用户");
        //userInfoService.userAdd(model);
        return "user";
    }

    @RequiresPermissions("admin:delete")
    @DeleteMapping("/delete")
    @ApiIgnore
    public String userDelete(Model model) {
        model.addAttribute("value", "删除用户");
        return "user";
    }

    @GetMapping("/userInfoList")
    public Result getUserInfoList() {
        log.info("------开始查询用户列表----");
        List<UserInfo> userInfos = userInfoService.selectUserInfoList();
        return new Success(userInfos);
    }


    @GetMapping("/account")
    @ApiIgnore
    public String index(Model m) {
        List<Account> list = new ArrayList<Account>();
        list.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
        list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
        list.add(new Account("Jane", "简", "e10adc3949ba59abbe56e", "运维人员", "18666666666"));
        list.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
        m.addAttribute("accountList", list);
        return "account";
    }

    @RequestMapping("test")
    @ApiIgnore
    public Result test1() {
        return new Success("success");
    }

    @RequestMapping("test2")
    @ApiIgnore
    public Result test2(String name) {
        System.out.println(name);
        return new Success(name);
    }
}
