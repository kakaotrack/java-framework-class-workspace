package kr.ac.jejunu.user;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class UserContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("************ context init **************");
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("************ context destroy **************");
        ServletContextListener.super.contextDestroyed(sce);
    }
}
