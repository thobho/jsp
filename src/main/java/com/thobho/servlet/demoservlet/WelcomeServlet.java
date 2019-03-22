package com.thobho.servlet.demoservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = "/hello",
        name = "AnnotationServlet", // can be referenced in web.xml
        initParams = {@WebInitParam(name = "initParam",value = "paramValue")},
        loadOnStartup = 1 //if greater than 0 then servlet load on startub
)
public class WelcomeServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        config.getInitParameter("initParam");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        getServletConfig().getInitParameter("initParam");
        getServletConfig().getServletContext().getInitParameter("initParam");


        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Hello</h1>");
    }

    @Override
    public void destroy() {
        super.destroy();
        //cleaning up
    }
}
