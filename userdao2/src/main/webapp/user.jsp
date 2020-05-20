<%@ page import="kr.ac.jejunu.user.UserDao" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="kr.ac.jejunu.user.User" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu.user");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
    User user = userDao.get(24);
%>
<html>
<h1>
    Hello <%=user.getName()%>!!!
</h1>
</html>