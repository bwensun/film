package com.bowensun.film.service.mapstruct;

import com.bowensun.film.domain.dto.RoleDTO;
import com.bowensun.film.domain.entity.RoleEntity;
import com.bowensun.film.domain.vo.RoleVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色 持久化对象转换器
 *
 * @author baiwang
 * @date 2021-04-16
*/
@Component
@Mapper(componentModel = "spring")
public interface RoleConverter {

    /**
    * DTO 转 PO
    *
    * @param role 数据传输对象
    * @return 返回持久化对象
    */
    RoleEntity from(RoleDTO role);

    /**
    * DTO 转 PO
    *
    * @param roleList 数据传输对象列表
    * @return 返回持久化对象列表
    */
    List<RoleEntity> fromList(List<RoleDTO> roleList);


    /**
    * PO 转 VO
    *
    * @param role 持久化对象
    * @return 返回视图对象
    */
    RoleVO to(RoleEntity role);

    /**
    * PO 转 VO 列表
    *
    * @param roleList 持久化对象列表
    * @return 返回视图对象列表
    */
    List<RoleVO> toList(List<RoleEntity> roleList);

}