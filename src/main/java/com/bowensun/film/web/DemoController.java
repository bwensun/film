package com.bowensun.film.web;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bowensun.film.domain.USER;

import com.bowensun.film.repository.USERMapper;
import com.bowensun.film.repository.mybatis.UserInfoDao;
import com.bowensun.film.repository.jpa.UserRepository;
import com.bowensun.film.service.UserService;
import com.bowensun.film.web.aop.log.LogT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
    public List<USER> selectUserInfoList(Integer pageNumber, Integer pageSize) {
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


    public static void main(String[] args) throws URISyntaxException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 38; i++) {
            String s = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
            System.out.println(s);
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