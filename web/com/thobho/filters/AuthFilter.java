package com.thobho.filters;

import com.thobho.model.User;
import com.thobho.service.UserRegisterException;
import com.thobho.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

public class AuthFilter implements Filter {

    private UserService userService;

    public void init(FilterConfig config) throws ServletException {
        userService = new UserService();
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws java.io.IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Cookie[] cookies = httpRequest.getCookies();

        Integer loggedUserId = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("loggedUserId"))
                .findAny()
                .map(Cookie::getValue)
                .map(Integer::parseInt)
                .orElseThrow(UserRegisterException::new);

        Optional<User> userOptional = userService.getUser(loggedUserId);

        if(userOptional.isPresent()){
            User user = userOptional.get();
        }

        String secretToken = (String) httpRequest.getSession().getAttribute("secretToken");

        if (secretToken == null || userOptional.isPresent() && !secretToken.equals(userOptional.get().createSecretToken())) {
            throw new UserRegisterException();
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
        /* Called before the Filter instance is removed from service by the web container*/
    }
}
