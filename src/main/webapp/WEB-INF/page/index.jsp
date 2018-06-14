<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>user login</h1>
	<form action="/shiroDemo/index/dologin" method="post">
		username:<input type="text" name="userName">
		<p>
			password:<input type="password" name="password">
		<p>
			<input type="submit" value="登录">
			<p>${message} </p>
	</form>
</body>
</html>