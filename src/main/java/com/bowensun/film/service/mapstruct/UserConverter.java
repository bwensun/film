package com.bowensun.film.service.mapstruct;

import java.util.List;


import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.dto.UserRegisterDTO;
import com.bowensun.film.domain.entity.UserEntity;
import com.bowensun.film.domain.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

/**
 * 用户 持久化对象转换器
 *
 * @author baiwang
 * @date 2021-04-16
*/
@Component
@Mapper(componentModel = "spring")
public interface UserConverter {

    /**
    * DTO 转 PO
    *
    * @param user 数据传输对象
    * @return 返回持久化对象
    */
    @Mapping(target = "remark", ignore = true)
    UserEntity from(UserDTO user);

    /**
    * DTO 转 PO
    *
    * @param userList 数据传输对象列表
    * @return 返回持久化对象列表
    */
    List<UserEntity> fromList(List<UserDTO> userList);


    /**
    * PO 转 VO
    *
    * @param user 持久化对象
    * @return 返回视图对象
    */
    @Mapping(target = "index", ignore = true)
    UserVO to(UserEntity user);

    /**
    * PO 转 VO 列表
    *
    * @param userList 持久化对象列表
    * @return 返回视图对象列表
    */
    List<UserVO> toList(List<UserEntity> userList);

    /**
     * 注册DTO 转 PO
     *
     * @param user 注册DTO
     * @return PO
     */
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "sex", ignore = true)
    @Mapping(target = "remark", ignore = true)
    @Mapping(target = "phoneNumber", ignore = true)
    @Mapping(target = "level", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "avatar", ignore = true)
    @Mapping(target = "activity", ignore = true)
    UserEntity dto2Po(UserRegisterDTO user);
}