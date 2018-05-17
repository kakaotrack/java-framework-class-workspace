package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter
public class HelloFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("***********  filter init ****************");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("***********  filter start ****************");
        chain.doFilter(request, response);
        log.info("***********  filter end ****************");

    }

    @Override
    public void destroy() {
        log.info("***********  filter destroy ****************");
    }
}
