package kr.ac.jejunu.user;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class UserRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("************* request destroy ****************");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("************* request init ****************");
    }
}
