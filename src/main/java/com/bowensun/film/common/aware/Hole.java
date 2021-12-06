package com.bowensun.film.common.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/11/17
 */
@Component
public class Hole implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }
}
