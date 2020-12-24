package com.bowensun.film.web;

import com.bowensun.film.domain.USER;

import com.bowensun.film.service.UserService;
import com.bowensun.film.web.aop.log.LogT;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.*;


/**
 * @author 郑建雄
 * @date 2019/3/18
 */
@RestController
@RequestMapping(value = "demo")
@Slf4j
@Api(value = "测试功能相关接口<DemoController>", tags = "DemoController", description = "测试功能相关接口")
public class DemoController {

    @Autowired
    private UserService userService;

    @LogT
    @GetMapping(value = "/userList")
    @ApiOperation(value = "根据用户名查询数据", notes = "测试DynamicSQL功能")
    public PageInfo<USER> selectUserInfoList(Integer pageNumber, Integer pageSize) {
        return userService.selectUserInfoList(pageNumber, pageSize);
    }

    @LogT
    @GetMapping(value = "/user/{uid}")
    public USER selectByPrimaryKey(@PathVariable Integer uid) {
        return userService.selectByPrimaryKey(uid);
    }

    @LogT
    @DeleteMapping(value = "/user/{uid}")
    public void deleteByPrimaryKey(@PathVariable Integer uid) {
        userService.deleteByPrimaryKey(uid);
    }

    @LogT
    @PutMapping(value = "/update")
    public void updateUser(USER user) {
        userService.updateByPrimaryKeySelective(user);
    }

    @LogT
    @PostMapping(value = "/insert")
    public void insertUser(USER user) {
        userService.insertByPrimaryKeySelective(user);
    }


    public static void main(String[] args) throws URISyntaxException, ParseException {
        ArrayList<USER> strings = new ArrayList<>();
        USER user = new USER();
        user.setName("zjx");
        strings.add(null);
        strings.add(user);
        strings.add(user);
        strings.add(user);
        strings.add(user);
        for (USER string : strings) {
            try {
                System.out.println(string.getName());
            }catch (Exception e){
                System.out.println(e.getMessage());

            }
        }
    }

    @LogT
    @PostMapping(value = "/session")
    public void insertUser(HttpSession session) {
        userService.selectUserInfoList();
        System.out.println("============>进入");
        Object name = session.getAttribute("name");
        System.out.println(name);
    }

    @LogT
    @PostMapping(value = "/addsession")
    public void setSession(HttpSession session) {
        System.out.println("============>进入add");
        session.setAttribute("name", "123");
    }

    @LogT
    @PostMapping(value = "/export")
    public void export(HttpServletResponse response) throws IOException {
//        List<USER> users = userService.selectUserInfoList();
//        ExportParams exportParams = new ExportParams("用户信息表", "用户信息");
//        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, USER.class, users);
//        workbook.write(response.getOutputStream());
//        response.getOutputStream().flush();
    }

    @LogT
    @PostMapping(value = "/templateExport")
    public void templateExport(HttpServletResponse response) throws IOException {
//        TemplateExportParams templateExportParams = new TemplateExportParams("export/templateExport.xlsx");
//        List<USER> users = userService.selectUserInfoList();
//        List<Object> collect = users.stream().map(x -> JSONObject.toJSON(x))
//                .collect(Collectors.toList());
//        Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams,);
//        workbook.write(response.getOutputStream());
//        response.getOutputStream().flush();
    }


}