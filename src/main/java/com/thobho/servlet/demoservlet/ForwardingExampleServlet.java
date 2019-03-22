package com.thobho.servlet.demoservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/forwarding")
public class ForwardingExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do get in servlet");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("receiver");

        PrintWriter writer = resp.getWriter();
        writer.println("from forwarder2");
        writer.flush();
        requestDispatcher.forward(req, resp);

    }
}
