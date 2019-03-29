package com.thobho.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(
        filterName = "Logging filter",
        urlPatterns = "/hello",
        initParams = {@WebInitParam(name = "name", value = "value")}
)
public class LoggingFilter implements Filter {

    private final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.warning(filterConfig.getInitParameter("name"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("protocol is " + request.getProtocol());
        logger.info("remote host is " + request.getRemoteHost());
        logger.info("content type is " + request.getContentType());
        logger.info("content length is " + request.getContentLength());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
