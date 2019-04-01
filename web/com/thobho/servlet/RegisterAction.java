package com.thobho.servlet;


import com.thobho.filters.AuthFilter;
import com.thobho.model.User;
import com.thobho.service.UserRegisterException;
import com.thobho.service.UserService;
import com.thobho.servlet.demoservlet.WelcomeServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/registerAction", initParams = {@WebInitParam(name = "test", value = "test")})
public class RegisterAction extends HttpServlet {

    private static final int MIN_LOGIN_LENGTH = 4;
    public static final int MIN_PASS_LENGTH = 4;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        ServletContext servletContext = getServletContext();
        servletContext.getAttribute("contextAttribute");
        servletContext.getInitParameter("initParameter");
        servletContext.addFilter("filter", AuthFilter.class);
        servletContext.addServlet("servlet", WelcomeServlet.class);

        HttpSession session = req.getSession();
        session.getAttribute("sessionAtribute");
        session.getId();
        session.getCreationTime();
        session.getLastAccessedTime();
        session.getMaxInactiveInterval();

        HttpServletRequest request = req;
        request.getCookies();
        request.getHeader("header");
        request.getParts(); //for multipart requests
        request.getRequestURL();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (!validateLogin(login) || !validatePassword(password)) {
            throw new UserRegisterException();
        }

        Optional<User> createdUser = userService.createUser(login, password);


        if (!createdUser.isPresent()) {
            // resp.sendRedirect("userExists.jsp");
            resp.sendError(400);
        } else {
            resp.sendRedirect("login2.jsp");
        }
    }

    private boolean validateLogin(String login) {
        return login.length() > MIN_LOGIN_LENGTH;
    }

    private boolean validatePassword(String password) {
        return password.length() > MIN_PASS_LENGTH;
    }


    private String generateRandomColor() {
        return Integer.toHexString((int) (Math.random() * 0x1000000));
    }

    private Cookie generateCookie(String color) {
        Cookie randomUserColor = new Cookie("randomUserColor", color);
        randomUserColor.setMaxAge(60 * 10);
        return randomUserColor;
    }



}
