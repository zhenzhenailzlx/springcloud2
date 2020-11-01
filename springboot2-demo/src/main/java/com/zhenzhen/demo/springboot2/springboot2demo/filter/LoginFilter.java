package com.zhenzhen.demo.springboot2.springboot2demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("调用com.zhenzhen.demo.springboot2.springboot2demo.LoginFilter.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("调用com.zhenzhen.demo.springboot2.springboot2demo.LoginFilter.doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("调用com.zhenzhen.demo.springboot2.springboot2demo.LoginFilter.destroy");
    }
}
