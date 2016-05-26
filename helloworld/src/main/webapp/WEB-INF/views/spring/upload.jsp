<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
    <h1>File Upload</h1>
    <form action="/spring/upload" method="POST" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit"/>
    </form>
    <img src="${url}" />

</body>
</html>