package kr.ac.jejunu.spring;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("kr.ac.jejunu");
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dipatcher"
                , new DispatcherServlet(context));
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }
}
