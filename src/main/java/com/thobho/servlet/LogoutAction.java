package com.thobho.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.invalidate();
        resp.addCookie(generateResetingCookie());
    }

    private Cookie generateResetingCookie(){
        Cookie cookie = new Cookie("loggedUserId", "");
        cookie.setMaxAge(0);
        return cookie;
    }


}
