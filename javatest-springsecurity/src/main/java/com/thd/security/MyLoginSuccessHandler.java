package com.thd.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;
import org.springframework.stereotype.Component;
@Component("myLoginSuccessHandler")
public class MyLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler  {
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("登录成功!");
		System.out.println("用户名:" + SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println("权限" + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		WebAuthenticationDetails loginUserInfo = (WebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		System.out.println("IP" + loginUserInfo.getRemoteAddress());
		System.out.println("SessionId" + loginUserInfo.getSessionId());
		System.out.println("登录用户信息" + loginUserInfo);
		
		System.out.println(obj);
		super.onAuthenticationSuccess(request, response, authentication);
		
		
		
		/*
        if (ObjectUtils.equals(securityProperties.getBrowser().getLoginType(), LoginType.JSON)) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(new SimpleResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), authentication)));
        } else {
            // 会帮我们跳转到上一次请求的页面上
             * super.onAuthenticationSuccess(request, response, authentication);
            
        }*/
        
		
	}

}
