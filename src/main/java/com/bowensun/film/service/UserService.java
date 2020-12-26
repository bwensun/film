package com.bowensun.film.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bowensun.film.domain.UserPO;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.vo.UserVO;

import java.util.List;

/**
 * 用户service
 *
 * @author bowensun
 * @date 2018/11/9
 */
public interface UserService {

    /**
     * 用户分页查询
     *
     * @param user UserDTO
     * @return PageInfo<UserPO>
     */
    Page<UserPO> selectPage(UserDTO user);

    /**
     * list查询
     *
     * @param user user
     * @return List<UserVO>
     */
    List<UserVO> selectList(UserDTO user);
}
