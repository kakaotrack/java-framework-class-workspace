package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class HelloServlet extends GenericServlet {
    @Override
    public void destroy() {
        log.info("************* servlet destroy *************");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("************* servlet init *************");
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.info("************* servlet service *************");
        res.getWriter().println("<h1>Hello World</h1>");
    }
}
