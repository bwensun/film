package com.bowensun.film.service.impl;

import com.baiwang.customize.generator.util.WrapperUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baiwang.customize.generator.util.PageUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bowensun.film.common.config.redis.RedisCache;
import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.common.util.JwtUtil;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.entity.UserEntity;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.repository.UserMapper;
import com.bowensun.film.service.UserService;
import com.bowensun.film.service.mapstruct.UserConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户Service业务层处理
 *
 * @author baiwang
 * @date 2021-04-16
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Resource
    private UserMapper mapper;

    @Resource
    private UserConverter converter;

    @Resource
    private RedisCache redisCache;

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
        return mapper.insert(entity);
    }

    @Override
    public int update(UserDTO dto) {
        UserEntity entity = converter.from(dto);
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

    @Override
    public UserDTO getUserDtoByUsername(String username) {
        return mapper.getUserDtoByUsername(username);
    }

    @Override
    public void activityAdjust(Long userId, double delta) {
        String key = BizConstant.ACTIVITY_RANK_KEY;
        Double score = redisCache.score(key, userId);
        if (Objects.isNull(score)) {
            redisCache.setSortObject(key, userId, 0);
        } else {
            redisCache.incrementScore(key, userId, delta);
        }
    }



    @Override
    public UserVO getUserInfo(Long id) {
        return this.selectById(id);
    }

    /**
     * 查询语句构造器
     *
     * @param dto 数据传输对象
     * @return 返回一个查询构造器
     */
    private QueryWrapper<UserEntity> getQueryWrapper(UserDTO dto) {
        return WrapperUtils.<UserEntity>of()
                .like("username", dto.getUsername())
                .end();
    }
}
