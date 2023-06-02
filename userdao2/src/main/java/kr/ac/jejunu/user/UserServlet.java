package kr.ac.jejunu.user;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller("/servlet")
@WebServlet(urlPatterns = "/servlet")
public class UserServlet extends GenericServlet {
    @Autowired
    private UserDao userDao;

    @Override
    public void destroy() {
        System.out.println("************* destroy ***************");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("kr.ac.jejunu.user");
        userDao = applicationContext.getBean("userDao", UserDao.class);
        System.out.println("************* init ***************");
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name =
                userDao.findById(Long.parseLong(req.getParameter("id")))
                        .getName();
        System.out.println("************* service ***************");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<body>");
        stringBuffer.append("<h1>");
        stringBuffer.append(String.format("Hello %s", name));
        stringBuffer.append("</h1>");
        stringBuffer.append("</body>");
        stringBuffer.append("</html>");
        res.getWriter().println(stringBuffer.toString());
    }
}
