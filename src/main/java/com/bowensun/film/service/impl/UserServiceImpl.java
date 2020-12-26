package com.bowensun.film.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bowensun.film.common.mapstruct.UserConverter;
import com.bowensun.film.domain.UserPO;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.repository.UserMapper;
import com.bowensun.film.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Service实现
 *
 * @author 郑建雄
 * @date 2020/12/26
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserConverter userConverter;

    @Override
    public Page<UserPO> selectPage(UserDTO user) {
        return userMapper.selectPage(new Page<>(user.getPageNumber(), user.getPageSize()), new QueryWrapper<>());
    }

    @Override
    public List<UserVO> selectList(UserDTO user) {
        List<UserPO> poList = userMapper.selectList(new QueryWrapper<>());
        return userConverter.poList2VoList(poList);
    }
}
