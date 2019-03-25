package com.thd.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
	private UserDetailsService userDetailsService;
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		SmsCodeAuthenticationToken token = (SmsCodeAuthenticationToken)authentication;
		UserDetails userDetails = userDetailsService.loadUserByUsername(token.getPrincipal().toString());
		if(userDetails == null){
			throw new BadCredentialsException("user not be found");
		}
		SmsCodeAuthenticationToken tokenResult = new SmsCodeAuthenticationToken(userDetails,userDetails.getAuthorities());
		tokenResult.setDetails(token.getDetails());
		return tokenResult;
	}

	public boolean supports(Class<?> authentication) {
		return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

}
