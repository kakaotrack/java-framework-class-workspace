package kr.ac.jejunu;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class UserServlet extends GenericServlet {
    @Override
    public void destroy() {
        System.out.println("********* destroy ***********");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("*********  init ***********");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("********* service ***********");
    }
}
