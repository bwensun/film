package com.bowensun.film.common.mapstruct;

import com.bowensun.film.domain.UserPO;
import com.bowensun.film.domain.vo.UserVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * 用户转换器
 *
 * @author 郑建雄
 * @date 2020/12/26
 */
@Component
@Mapper(componentModel = "spring")
public interface UserConverter {

    /**
     * po2Vo
     *
     * @param userPo  UserPO
     * @return UserVO
     */
    UserVO po2Vo(UserPO userPo);

    /**
     * po2Vo
     *
     * @param userPo UserPO
     * @return UserVO
     */
    List<UserVO> poList2VoList(List<UserPO> userPo);
}
