package com.bowensun.film.service.mapstruct;

import java.util.List;

import com.bowensun.film.domain.dto.ResourceDTO;
import com.bowensun.film.domain.entity.ResourceEntity;
import com.bowensun.film.domain.vo.ResourceVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * 资源权限 持久化对象转换器
 *
 * @author baiwang
 * @date 2021-04-21
*/
@Component
@Mapper(componentModel = "spring")
public interface ResourceConverter {

    /**
    * DTO 转 PO
    *
    * @param resource 数据传输对象
    * @return 返回持久化对象
    */
    ResourceEntity from(ResourceDTO resource);

    /**
    * DTO 转 PO
    *
    * @param resourceList 数据传输对象列表
    * @return 返回持久化对象列表
    */
    List<ResourceEntity> fromList(List<ResourceDTO> resourceList);


    /**
    * PO 转 VO
    *
    * @param resource 持久化对象
    * @return 返回视图对象
    */
    ResourceVO to(ResourceEntity resource);

    /**
    * PO 转 VO 列表
    *
    * @param resourceList 持久化对象列表
    * @return 返回视图对象列表
    */
    List<ResourceVO> toList(List<ResourceEntity> resourceList);

}