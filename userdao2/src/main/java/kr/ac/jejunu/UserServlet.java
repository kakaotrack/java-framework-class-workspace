package kr.ac.jejunu;

import javax.servlet.*;
import java.io.IOException;

public class UserServlet extends GenericServlet {
    @Override
    public void destroy() {
        System.out.println("*************** destroy *****************");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("*************** init *****************");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("*************** service *****************");
    }
}
