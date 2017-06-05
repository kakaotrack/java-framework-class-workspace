package kr.ac.jejunu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by hyh0408 on 2017. 5. 9..
 */
@WebListener
public class HelloContextListener implements ServletContextListener{

    private static Logger logger = LoggerFactory.getLogger(HelloContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("***************  context init *************");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("***************  context destroy *************");
    }
}
