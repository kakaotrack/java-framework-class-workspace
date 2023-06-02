package kr.ac.jejunu.user;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//        XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.scan("kr.ac.jejunu.user");
//        applicationContext.setNamespace("dispatcher-servlet");
        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");

    }
}
