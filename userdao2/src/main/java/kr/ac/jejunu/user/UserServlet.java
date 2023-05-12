package kr.ac.jejunu.user;

import jakarta.servlet.*;

import java.io.IOException;

public class UserServlet extends GenericServlet {
    @Override
    public void destroy() {
        System.out.println("************* destroy ***************");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("************* init ***************");
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("************* service ***************");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<body>");
        stringBuffer.append("<h1>");
        stringBuffer.append("Hello Hulk");
        stringBuffer.append("</h1>");
        stringBuffer.append("</body>");
        stringBuffer.append("</html>");
        res.getWriter().println(stringBuffer.toString());
    }
}
