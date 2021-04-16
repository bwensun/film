package com.bowensun.film.service.impl;

import com.baiwang.customize.generator.util.WrapperUtils;
import com.baiwang.customize.generator.util.DateUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baiwang.customize.generator.util.PageUtils;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.entity.UserEntity;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.repository.UserMapper;
import com.bowensun.film.service.UserService;
import com.bowensun.film.service.mapstruct.UserConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户Service业务层处理
 *
 * @author baiwang
 * @date 2021-04-16
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    @Resource
    private UserConverter converter;

    /**
     * 查询用户
     *
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public UserVO selectById(Long id) {
        return converter.to(mapper.selectById(id));
    }

    @Override
    public List<UserVO> selectList(UserDTO dto) {
        List<UserEntity> result = mapper.selectList(getQueryWrapper(dto));
        return converter.toList(result);
    }

    @Override
    public IPage<UserVO> selectPaging(UserDTO dto) {
        IPage<UserEntity> page = PageUtils.getPage(dto);
        IPage<UserEntity> result = mapper.selectPage(page, getQueryWrapper(dto));
        return PageUtils.convert(result, converter::to);
    }

    @Override
    public int insert(UserDTO dto) {
        UserEntity entity = converter.from(dto);
        entity.setCreateTime(DateUtils.getNowDate());
        return mapper.insert(entity);
    }

    @Override
    public int update(UserDTO dto) {
        UserEntity entity = converter.from(dto);
        entity.setUpdateTime(DateUtils.getNowDate());
        return mapper.updateById(entity);
    }

    @Override
    public int deleteByIds(Long[] ids) {
        return mapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }

    /**
     * 查询语句构造器
     * @param dto 数据传输对象
     * @return 返回一个查询构造器
     */
    private QueryWrapper<UserEntity> getQueryWrapper(UserDTO dto) {
        return WrapperUtils.<UserEntity>of()
            .like("username", dto.getUsername())
            .end();
    }
}
