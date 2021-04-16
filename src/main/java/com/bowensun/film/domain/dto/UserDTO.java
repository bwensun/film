package com.bowensun.film.domain.dto;

import com.baiwang.customize.generator.IPageParam;
import com.baiwang.customize.generator.dto.PageDTO;
import java.util.Date;
import lombok.*;

/**
 * 用户对象 user <br/>
 * 数据传输对象 <br/>
 * <b>PageDTO 并不是必须的，为了解耦提供了 IPageParam 接口</b>
 * 
 * @author baiwang
 * @date 2021-04-16
 */
@ToString(callSuper = true)
@Getter
@Setter
public class UserDTO extends PageDTO implements IPageParam{


    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

}