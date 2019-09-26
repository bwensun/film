package com.bowensun.film.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Builder;

import javax.annotation.Generated;

@Builder
public class USER {

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @Excel(name = "ID", height = 8, width = 14)
    private Integer uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @Excel(name = "用户姓名", height = 8, width = 14)
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @Excel(name = "密码", height = 8, width = 14)
    private String password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @Excel(name = "盐值", height = 8, width = 14)
    private String salt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @Excel(name = "状态", height = 8, width = 14)
    private Byte state;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @Excel(name = "用户名", height = 8, width = 14)
    private String username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getUid() {
        return uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPassword() {
        return password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSalt() {
        return salt;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getState() {
        return state;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setState(Byte state) {
        this.state = state;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUsername() {
        return username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}