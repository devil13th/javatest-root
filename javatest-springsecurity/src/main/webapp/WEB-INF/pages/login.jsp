<%@ page language="java" contentType="text/html; charset=UTF-8"    
pageEncoding="UTF-8"%> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>    
<head>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
<title>用户登录页面</title>   
<script>
function refreshValidateCode(){
	
	document.getElementById("validateCodeImage").src = "<c:url value='/code/image' />?_r=" + Math.random()
	
}
</script>
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
<c:if test="${requestScope.error != ''}">
<span style="color:red"> [ ${requestScope.error} ]</span> 
</c:if>
    ${title}
<form action="<c:url value='loginSubmit' />" method="post">    

<label for="userName">. 手机号：</label>     
<input id="userName" name="mobile" /><br />        
<label for="userName">验证码：</label> 
<input type="text" name="imageCode"/>

<a href="<c:url value='/code/sms' />" target="_blank">发送</a>

<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			
			
<input type="submit" value=" 登录 " />    
</form>    
</body>    
</html>    
          