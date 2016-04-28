package kr.ac.jejunu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hyh0408 on 2016. 4. 28..
 */
@WebListener
public class HelloRequestListener implements ServletRequestListener{

    private final static Logger logger = LoggerFactory.getLogger(HelloRequestListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("******** request listener destroy **********");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("******** request listener init **********");

    }
}
