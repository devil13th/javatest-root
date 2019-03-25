<%@ page language="java" contentType="text/html; charset=UTF-8"    
pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>    
<head>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
<title>用户登录页面</title>    
</head>    
<body>    
<p style="color:red;" >${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</p>  

<!-- 
<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">    
    
<label for="userName">用户名：</label>     
<input id="userName" name="j_username" /><br />     
<label for="password">密  码：</label>    
<input id="password" type="password" name="j_password" /><br />   


<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
 -->  
 
 <form action="${pageContext.request.contextPath}/login" method="post">    
    
<label for="userName">用户名：</label>     
<input id="userName" name="usr" /><br />     
<label for="password">密  码：</label>    
<input id="password" type="password" name="pwd" /><br />   

<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			
			
<input type="submit" value=" 登录 " />    
</form>    
</body>    
</html>    
          