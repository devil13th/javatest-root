<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h1>标题: ${title}</h1>
	<h1>消息 : ${message}</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
	   <h2>欢迎: ${pageContext.request.userPrincipal.name} | ${pageContext.request.userPrincipal}
           | <a href="<c:url value="/logoutSubmit" />" > Logout</a></h2>  
	</c:if>
</body>
</html>