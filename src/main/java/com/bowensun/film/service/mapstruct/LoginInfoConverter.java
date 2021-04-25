package com.bowensun.film.service.mapstruct;

import com.bowensun.film.domain.LoginUser;
import com.bowensun.film.domain.entity.LoginInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

/**
 * LoginInfo相关转换
 *
 * @author 郑建雄
 * @date 2021/4/25
 */
@Component
@Mapper(componentModel = "spring")
public interface LoginInfoConverter {

    /**
     * loginUser 转 LoginInfoEntity
     *
     * @param loginUser LoginUser
     * @return LoginInfoEntity
     */
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "msg", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loginTime", expression = "java(new java.util.Date())")
    LoginInfoEntity to(LoginUser loginUser);
}
