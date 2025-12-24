package com.sourjelly.snsproject.interceptor;

import com.sourjelly.snsproject.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class PermissionInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(
            HttpServletRequest request
            , HttpServletResponse response
            , Object handler) throws IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String uri = request.getRequestURI();

        // 로그인 안되어 있다면 게시글 메인페이지, 게시글 수정 페이지, 메세지 보내는 페이지를 막는다.
        if(user == null){
            if(uri.startsWith("/post") || uri.startsWith("/main")){

                response.sendRedirect("/user/login");

                return false;
            }
        }else{
            // 로그인이 되어있는경우 로그인이나 회원가입 페이지 빼고 전부 사용가능

            if(uri.startsWith("/user")){

                response.sendRedirect("/main/list");

                return false;
            }
        }
        return true;
    }

}
