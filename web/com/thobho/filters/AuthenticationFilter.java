package com.thobho.filters;

import com.thobho.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(urlPatterns = "/secret/*")
public class AuthenticationFilter implements Filter {

    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userService = new UserService();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Cookie[] cookies = httpRequest.getCookies();

        //sprawdzenie czy jest ciasteczko (bilet do wejśćia na strone)
        String cookieValue = "";
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("userCookieId")){
                cookieValue = cookies[i].getValue();
            }
        }

        //przwdzenie, czy w sesji jest taki user
        Integer loggedUserId = (Integer) httpRequest
                .getSession().getAttribute("loggedUserId");

        if(cookieValue.equals("") ||
            !cookieValue.equals(loggedUserId.toString())){
            //throw exepcption
            throw new AuthenticationException();
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }




//    Optional<Cookie> userCookieId = Arrays.stream(cookies)
//                .filter(cookeie -> cookeie.getValue().equals("userCookieId"))
//                .findAny()
//                .ifPresent(() -> {
//                    //
//                });
}
