package kr.ac.jejunu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import java.io.IOException;

public class UserServlet extends GenericServlet {
    private UserDao userDao;
    @Override
    public void destroy() {
        System.out.println("*************** destroy *****************");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("kr.ac.jejunu");
        userDao = applicationContext.getBean("userDao", UserDao.class);
        System.out.println("*************** init *****************");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("*************** service *****************");
        Integer id = Integer.parseInt(req.getParameter("id"));
        User user = userDao.findById(id);
        res.setContentType("text/html; charset=UTF-8");
        StringBuffer response = new StringBuffer();
        response.append("<html>");
        response.append("<body>");
        response.append("<h1>");
        response.append(String.format("Hello %s !!!", user.getName()));
        response.append("</h1>");
        response.append("</body>");
        response.append("</html>");
        res.getWriter().println(response.toString());
    }
}
