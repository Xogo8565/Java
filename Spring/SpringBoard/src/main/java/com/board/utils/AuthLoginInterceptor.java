package com.board.utils;

import com.board.member.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//D.S 와 Controller 사이에서 요청 / 응답을 가로채서 추가적인 처리를 해줄 수 있는 클래스
// loginSession 이라는 키값이 세션에 들어있는지 검사
public class AuthLoginInterceptor implements HandlerInterceptor {

    // preHandle : DS가 controller 에게 요청을 보내기 전에 실행되는 메서드
    // postHandle : controller 가 DS 에게 응답을 보내기 전에 실행되는 메서드

    // true -> Intercepter 를 거친 후 DS / Controller 에 요청 응답값을 정상적으으로 전달
    Logger logger = LoggerFactory.getLogger(AuthLoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("LoginInterceptor");
        if(request.getSession().getAttribute("loginSession") == null ) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
