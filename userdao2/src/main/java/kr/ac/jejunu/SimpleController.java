package kr.ac.jejunu;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
