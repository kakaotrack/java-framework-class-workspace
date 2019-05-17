<%--
  Created by IntelliJ IDEA.
  User: hyh0408
  Date: 2019-05-02
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <form action="/user/user" method="GET">
    <p> id: <input type="text" name="id"/> </p>
    <p> name: <input type="text" name="name"/> </p>
    <p> password: <input type="text" name="password"/> </p>
    <input type="submit" />
  </form>
  <p>id : ${user.id}</p>
  <p>name : ${user.name}</p>
  <p>password : ${user.password}</p>
  </body>
</html>
