package com.bowensun.film.web;

import com.bowensun.film.domain.USER;
import com.bowensun.film.service.UserService;
import com.bowensun.film.web.support.BaseController;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 郑建雄
 * @date 2019/11/22
 */
@RestController
@RequestMapping("user")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController extends BaseController {


    private final UserService userService;

    @GetMapping("userList")
    @JsonView(USER.UserListView.class)
    public List<USER> getUserList(){
        log.info("====>");
        return userService.selectUserInfoList();
    }

    @PostMapping("add")
    public void insert(USER user){
         userService.insert(user);
    }
}
