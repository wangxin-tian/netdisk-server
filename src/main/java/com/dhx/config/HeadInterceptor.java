package com.dhx.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeadInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求中的token
        String authorization = request.getHeader("authorization");
        request.setAttribute("_id", "");
        if (authorization == null ) {
            return true;
        }
        String token = authorization.split(" ")[1];
        System.out.println("----------------------" + token);
        Verify verify = Jwt.verifyToken(token);
        // 验证token
        if (verify.status) {
            request.setAttribute("_id", verify.userId + " " + token);
        }
        return true;
    }
}
