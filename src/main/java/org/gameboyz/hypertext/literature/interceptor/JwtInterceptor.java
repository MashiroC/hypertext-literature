package org.gameboyz.hypertext.literature.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.gameboyz.hypertext.literature.been.jwt.Jwt;
import org.gameboyz.hypertext.literature.been.jwt.JwtHelper;
import org.gameboyz.hypertext.literature.been.jwt.JwtOverTimeException;
import org.gameboyz.hypertext.literature.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Shiina18
 * @date: 2019/6/7 11:17
 * @description:
 */
@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    private static final Pattern JWT_PATTERN = Pattern.compile("Bearer\\s+(.*)");

    @Autowired
    private JwtHelper<User> jwtHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authorization = request.getHeader("Authorization");
        Matcher matcher = JWT_PATTERN.matcher(authorization);
        if (matcher.find()) {
            String jwtStr = matcher.group(1);
            Jwt jwt = Jwt.fromString(jwtStr);
            if (jwtHelper.isAccess(jwt)) {
                if (!jwt.isOvertime()) {
                    Integer uid = Integer.parseInt((String) jwt.getParameter("uid"));
                    String nickname = (String) jwt.getParameter("nickname");
                    User user = new User(uid, nickname);
                    request.setAttribute("test","???");
                    request.setAttribute("user", user);
                    return true;
                }
                log.info("jwt: uid: {} overtime", jwt.getParameter("id"));
                throw new JwtOverTimeException();
            }
            log.warn("ip: {} jwt break", request.getHeader("X-Forwarded-For"));
            return false;
        }
        return false;
    }
}
