package com.thd.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;


public class ValidateCodeFilter extends OncePerRequestFilter {
	private AuthenticationFailureHandler authenticationFailureHandler;
	 
 
    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
		return authenticationFailureHandler;
	}

	public void setAuthenticationFailureHandler(
			AuthenticationFailureHandler authenticationFailureHandler) {
		this.authenticationFailureHandler = authenticationFailureHandler;
	}

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    	//当请求路径为/authentication/form，且请求为POST请求时，才执行验证。（对应登录页面发送的请求）
		String path = request.getContextPath();
        if (StringUtils.equals(path + "/loginSubmit", request.getRequestURI()) && StringUtils.equals(request.getMethod(), "POST")) {
 
            try {
                validate(new ServletWebRequest((request)));
                filterChain.doFilter(request, response);
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            }
        }else{
        	filterChain.doFilter(request, response);
        }
    }
 
    private void validate(ServletWebRequest request) throws ServletRequestBindingException, ValidateCodeException {
    	HttpSession session = request.getRequest().getSession();
    	//从请求中取出之前存入session的验证码
		ImageCode codeInSession = (ImageCode) session.getAttribute("VALIDATE_CODE");
		//获取form表单中用户输入的验证码
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");  //对应form表单中图片name
 
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("validate code can not be null");
        }
        if (codeInSession == null) {
            throw new ValidateCodeException("validate code note be found");
        }
        if (codeInSession.isExpired()) {
        	session.removeAttribute("VALIDATE_CODE");
            throw new ValidateCodeException("validate code be out of expired");
        }
        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("validate code not be match");
        }
 
        session.removeAttribute("VALIDATE_CODE");
    }
}
