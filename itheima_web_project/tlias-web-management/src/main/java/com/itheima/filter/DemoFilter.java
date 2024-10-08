package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override//初始化方法，一次性执行
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init初始方法执行");
    }

    @Override//过滤方法，每次请求都会执行，多次调用
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo 拦截到请求。。。放行前逻辑");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Demo 拦截到请求。。。放行后逻辑");
    }

    @Override//销毁方法，在应用关闭时执行，一次性执行
    public void destroy() {
        System.out.println("destroy销毁方法执行");
    }
}
