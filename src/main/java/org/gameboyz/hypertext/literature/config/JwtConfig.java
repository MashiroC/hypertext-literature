package org.gameboyz.hypertext.literature.config;

import org.gameboyz.hypertext.literature.been.jwt.JwtHelper;
import org.gameboyz.hypertext.literature.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: Shiina18
 * @date: 2019/6/5 21:34
 * @description:
 */
@Component
public class JwtConfig {

    @Value("${jwt.default.effective-time}")
    private Long effectiveTime;

    @Value("${jwt.default.secret}")
    private String secret;

    @Bean
    public JwtHelper<User> jwtHelper() {
        return new JwtHelper<>(JwtHelper.H_MAC_SHA256, effectiveTime, secret);
    }
}
