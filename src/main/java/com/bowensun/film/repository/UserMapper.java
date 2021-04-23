package com.bowensun.film.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 用户Mapper接口
 * 
 * @author baiwang
 * @date 2021-04-16
 */
@Repository
public interface UserMapper extends BaseMapper<UserEntity>{

    /**
     * 根据username获取UserDTO
     *
     * @param username 用户名
     * @return UserDTO
     */
    UserDTO getUserDtoByUsername(String username);
}
