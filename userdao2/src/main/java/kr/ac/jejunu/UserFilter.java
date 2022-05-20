package kr.ac.jejunu;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "*")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("******* Filter init ***********");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("******* Filter before ***********");
        chain.doFilter(request, response);
        System.out.println("******* Filter after ***********");
    }

    @Override
    public void destroy() {
        System.out.println("******* Filter destroy ***********");
        Filter.super.destroy();
    }
}
