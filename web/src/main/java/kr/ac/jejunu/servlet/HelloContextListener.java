package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class HelloContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("**********  context init ************");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("**********  context destroy ************");
    }
}
