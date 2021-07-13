package com.bowensun.film.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bowensun.film.common.config.redis.RedisCache;
import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.domain.entity.SysDictEntity;
import com.bowensun.film.domain.vo.DictVo;
import com.bowensun.film.repository.SysDictMapper;
import com.bowensun.film.service.SysDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 字典实现
 *
 * @author 郑建雄
 * @date 2021/7/13
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictEntity> implements SysDictService {

    @Resource
    private RedisCache redisCache;

    @Override
    public void initDict() {
        this.lambdaQuery()
                .select(SysDictEntity::getCategoryCode)
                .groupBy(SysDictEntity::getCategoryCode)
                .list()
                .forEach(dict -> {
                    //对应分类的字典项集合
                    Map<String, String> map = this.lambdaQuery()
                            .eq(SysDictEntity::getCategoryCode, dict.getCategoryCode())
                            .list()
                            .stream()
                            .collect(Collectors.toMap(SysDictEntity::getDictCode, SysDictEntity::getDictDesc));
                    //存入redis
                    redisCache.setCacheMap(BizConstant.DICT_KEY.concat(dict.getCategoryCode()), map);
                });
    }

    @Override
    public List<DictVo> getAllDict() {
        //获取所有字典key
        Set<String> keySet = redisCache.scan(BizConstant.DICT_KEY.concat("*"), 1000L);
        List<DictVo> dictVoList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(keySet)){
            keySet.forEach(key -> {
                DictVo dictVo = new DictVo();
                dictVo.setCategoryCode(key.replace(BizConstant.DICT_KEY, ""));
                Map<String, String> dictInfo = redisCache.getCacheMap(key);
                dictVo.setDictInfoMap(dictInfo);
                dictVoList.add(dictVo);
            });
        }
        return dictVoList;
    }

    @Override
    public Map<String, String> getDictInfo(String categoryCode) {
        return redisCache.getCacheMap(BizConstant.DICT_KEY.concat(categoryCode));
    }
}
