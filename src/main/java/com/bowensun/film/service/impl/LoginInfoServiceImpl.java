package com.bowensun.film.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bowensun.film.domain.entity.LoginInfoEntity;
import com.bowensun.film.repository.LoginInfoMapper;
import com.bowensun.film.service.LoginInfoService;
import org.springframework.stereotype.Service;

/**
 * 登录记录
 *
 * @author 郑建雄
 * @date 2021/4/25
 */
@Service
public class LoginInfoServiceImpl extends ServiceImpl<LoginInfoMapper, LoginInfoEntity> implements LoginInfoService {
}
