package com.thobho.servlet;


import com.thobho.model.User;
import com.thobho.service.UserRegisterException;
import com.thobho.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/registerAction")
public class RegisterAction extends HttpServlet {

    private static final int MIN_LOGIN_LENGTH = 4;
    public static final int MIN_PASS_LENGTH = 4;
    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
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
            resp.sendRedirect("login.jsp");
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
