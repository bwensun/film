package com.bowensun.film.common.util;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.common.properties.JwtTokenProperties;
import lombok.extern.slf4j.Slf4j;
import java.time.ZoneId;
import java.util.Date;

/**
 * jwt工具类
 *
 * @author 郑建雄
 * @date 2020/4/17
 */
@Slf4j
public class JwtUtil {

    /**
     * 获取token
     *
     * @return token
     */
    public static String createToken(Long userId){
        //生成签名
        JwtTokenProperties jwtTokenProperties = SpringUtil.getBean(JwtTokenProperties.class);
        Algorithm signer = Algorithm.HMAC256(jwtTokenProperties.getSecret());
        //过期时间
        int expiredTime = jwtTokenProperties.getExpiredTime();
        Date expiredDate = Date.from(
                LocalDateTimeUtil
                        .now()
                        .plusMinutes(expiredTime)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );
        //签发人
        String issuer = jwtTokenProperties.getIssuer();
        //受众
        String audience = jwtTokenProperties.getAudience();
        //主题
        String subject = jwtTokenProperties.getSubject();
        return JWT.create()
                .withIssuer(issuer)
                .withAudience(audience)
                .withSubject(subject)
                .withClaim(BizConstant.LOGIN_USER_ID, userId)
                .withExpiresAt(expiredDate)
                .sign(signer);
    }

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, Long id, String secret) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withClaim("id", id)
                .build();
        verifier.verify(token);
        return true;
    }

    /**
     * 解析Token获取Claims
     *
     * @param token token
     * @return Claim
     */
    public static Claim parseToken(String token, String name) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(name);
    }

    /**
     * 解析Token获取Claims
     *
     * @param token token
     * @return userId
     */
    public static Long parseToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(BizConstant.LOGIN_USER_ID).asLong();
    }
}
