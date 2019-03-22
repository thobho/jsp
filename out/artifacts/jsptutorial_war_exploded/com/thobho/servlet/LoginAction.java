package com.thobho.servlet;

import com.thobho.model.User;
import com.thobho.service.UserRegisterException;
import com.thobho.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class LoginAction extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");


        Optional<User> userByLogin = userService.getUserByLogin(login);

        if (userByLogin.isPresent() && userByLogin.get().getPassword().equals(password)) {
            req.getSession().setAttribute("secretToken", userByLogin.get().createSecretToken());
            Cookie authCookie = generateAuthCookie(userByLogin.get().getId());
            resp.addCookie(authCookie);
            resp.sendRedirect("secret/secret.jsp");
        } else {
            throw new UserRegisterException();
        }


    }

    private Cookie generateAuthCookie(int id) {
        Cookie randomUserColor = new Cookie("loggedUserId", Integer.toString(id));
        randomUserColor.setMaxAge(60 * 10);
        return randomUserColor;
    }

}
