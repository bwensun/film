package com.bowensun.film.service.mapstruct;

import java.util.List;


import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.entity.UserEntity;
import com.bowensun.film.domain.vo.UserVO;
import org.mapstruct.Mapper;
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
    UserVO to(UserEntity user);

    /**
    * PO 转 VO 列表
    *
    * @param userList 持久化对象列表
    * @return 返回视图对象列表
    */
    List<UserVO> toList(List<UserEntity> userList);

}