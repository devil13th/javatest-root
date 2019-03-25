package com.thd.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
@Component("myLoginFailureHandler")
public class MyLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	 @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
	        logger.info("登录失败.!" + exception.getMessage());
	        //response.setContentType("text/html;charset=UTF-8");
	       // super.onAuthenticationFailure(request, response, exception);
	        
	        response.sendRedirect("/s/login?error=" + exception.getMessage());
	        
	        
	        /*if (Objects.equals(securityProperties.getBrowser().getLoginType(), LoginType.JSON)) {
	            response.setContentType("application/json;charset=UTF-8");
	            response.getWriter().write(JSON.toJSONString(new SimpleResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), null)));
	        } else {
	            response.setContentType("text/html;charset=UTF-8");
	            super.onAuthenticationFailure(request, response, exception);
	        }*/

	    }
}
