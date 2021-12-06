package com.bowensun.film.web.prototype;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/10/26
 */
@Getter
@Setter
public class User extends AbstractPrototype{

    private String username;

    private Long age;

    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User)super.clone();
    }
}
