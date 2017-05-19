package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hyh0408 on 2017. 5. 19..
 */
@Controller("/request")
public class HttpReqeustController implements HttpRequestHandler{
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h2>HttpRequest Handler Hello World</h2>");
    }
}
