package kr.ac.jejunu.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import java.io.IOException;

public class UserServlet extends GenericServlet {
    private UserDao userDao;
    @Override
    public void destroy() {
        System.out.println("**************** destroy *****************");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("**************** init *****************");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu.user");
        this.userDao = applicationContext.getBean("userDao", UserDao.class);
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("*********** service **************");
        User user = userDao.get(24);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<h1>");
        stringBuffer.append(String.format("Hello %s!!!", user.getName()));
        stringBuffer.append("</h1>");
        stringBuffer.append("</html>");
        res.setContentType("text/html;charset=UTF-8");
        res.getWriter().println(stringBuffer.toString());
    }
}
