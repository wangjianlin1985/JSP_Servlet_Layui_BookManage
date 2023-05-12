package com.dreambamboo.filter;

import javax.servlet.*;
import java.io.IOException;
/**
 * @Author:dreambamboo
 * @Description:字符编码过滤器
 * @Date:2019/1/11 11:30
 * @Param:
 * @return:
 */
public class CharacterEncoding implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
