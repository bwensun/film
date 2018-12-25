package com.bowensun.film.repository;

import com.bowensun.film.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description
 *
 * @author bowensun
 * @date 2018/11/9
 */
@Repository
@Mapper
public interface PermissionDao {
    List<SysPermission> selectByUserName(@Param("username") String username);
}
