package kr.ac.jejunu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by hyh0408 on 2017. 5. 9..
 */
@WebListener
public class HelloRequestListener implements ServletRequestListener{

    private static Logger logger = LoggerFactory.getLogger(HelloRequestListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("*********  request destroy **********");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("*********  request init **********");

    }
}
