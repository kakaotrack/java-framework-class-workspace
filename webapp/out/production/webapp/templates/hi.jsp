<html>
<body>
<h1>헬로세상아!!!</h1>
<h1 th:text="${helloModel.hello + ' ' + helloModel.name}" />
<form method="POST" action="/hi/헐크">
<input type="submit" value="눌러유"/>
</form>
</body>
</html>
