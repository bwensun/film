//package com.bowensun.film.domain;
//
//import com.bowensun.film.domain.dto.UserDTO;
//import com.bowensun.film.domain.vo.UserVO;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Set;
//
///**
// * 描述
// *
// * @author 郑建雄
// * @date 2021/4/20
// */
//@Getter
//@Setter
//public class LoginUser implements UserDetails {
//
//    /**
//     * 用户唯一标识
//     */
//    private String token;
//
//    /**
//     * 登录时间
//     */
//    private Long loginTime;
//
//    /**
//     * 过期时间
//     */
//    private Long expireTime;
//
//    /**
//     * 登录IP地址
//     */
//    private String ipaddr;
//
//    /**
//     * 登录地点
//     */
//    private String loginLocation;
//
//    /**
//     * 浏览器类型
//     */
//    private String browser;
//
//    /**
//     * 操作系统
//     */
//    private String os;
//
//    /**
//     * 权限列表
//     */
//    private Set<String> permissions;
//
//    /**
//     * 用户信息
//     */
//    private UserVO user;
//
//    public LoginUser(UserVO user, Set<String> permissions) {
//        this.permissions = permissions;
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
