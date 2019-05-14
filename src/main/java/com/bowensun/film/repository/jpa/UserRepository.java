package com.bowensun.film.repository.jpa;

import com.bowensun.film.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/5/7
 */
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    //UserInfo findByUsernameAndUid(String username, String uid);
}
