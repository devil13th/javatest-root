<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>this is a index page</h1>
<a href="adminPage.jsp"> admin page</a><br/>
<a href="${pageContext.request.contextPath}/j_spring_security_logout">退出登陆</a>
Hello Security
</body>
</html>