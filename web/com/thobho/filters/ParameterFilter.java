package com.thobho.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;


@WebFilter(urlPatterns = "/*")
public class ParameterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    //inicjalizacja
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Enumeration<String> attributeNames = httpRequest.getAttributeNames();

        while (attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            String parameterValue = httpRequest.getParameter(attributeName);
            System.out.println(parameterValue);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //sprzatanie po sobie
    }
}
