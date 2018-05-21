<html>
<body>
<h1>User</h1>
<form action="/user" method="POST">
    ID : <input type="text" name="id" value="${user.id}" /><br />
    Name : <input type="text" name="name" value="${user.name}" /><br />
    Password : <input type="text" name="password" value="${user.password}" /><br />
    <input type="submit"/>
</form>
</body>
</html>