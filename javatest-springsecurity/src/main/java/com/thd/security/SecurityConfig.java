package com.thd.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("devil13th").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}
*/
	
	//密码加密
	@Bean
	public PasswordEncoder passwordEncoder(){
	    return new BCryptPasswordEncoder();
	}
	//用户验证服务
	@Autowired
	UserDetailsService myUserDetailsService;
	
	//登录成功后的处理
	@Autowired
	private AuthenticationSuccessHandler myLoginSuccessHandler;
	
	//登录失败后的处理
	@Autowired
	private AuthenticationFailureHandler myLoginFailureHandler;
	
	
	
	@Bean
	public AuthenticationProvider authenticationProvider(){
	    SmsCodeAuthenticationProvider authenticationProvider = new SmsCodeAuthenticationProvider();
	    authenticationProvider.setUserDetailsService(myUserDetailsService);
	    return authenticationProvider;
	}
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 SmsCodeAuthenticationFilter smsFilter = new SmsCodeAuthenticationFilter();
		 smsFilter.setAuthenticationManager(super.authenticationManagerBean());
		 smsFilter.setAuthenticationFailureHandler(myLoginFailureHandler);
		 smsFilter.setAuthenticationSuccessHandler(myLoginSuccessHandler);
		 AuthenticationProvider smsProvider =  authenticationProvider();
		 
		 ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
	     validateCodeFilter.setAuthenticationFailureHandler(myLoginFailureHandler);
		 
	  http
	  .authenticationProvider(smsProvider)
	  	.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) //在UsernamePasswordAuthenticationFilter前面加上validateCodeFilter
	  	.addFilterBefore(smsFilter, UsernamePasswordAuthenticationFilter.class) //在UsernamePasswordAuthenticationFilter前面加上validateCodeFilter
	  	
	  	.authorizeRequests()
	  		.antMatchers("/login","/logout","/index.jsp","/code/sms").permitAll() //无需认证就可访问的地址
	  		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")//需要ROLE_ADMIN角色才可以访问的地址
	  		.anyRequest().authenticated()//除了无需认证的地址其余地址许认证后访问  (这句要放在认证和授权规则后面)
	  		.and()
		.formLogin()//采用form登录方式
			.loginPage("/login")  //指定登录地址(未认证时跳转的界面)
			.loginProcessingUrl("/loginSubmit")  //登录提交地址(登录表单提交的action) 默认j_spring_security_check
			.failureUrl("/login?error") //登录失败跳转地址
			//.usernameParameter("usr")  //form中的用户名输入框name  默认username
			//.passwordParameter("pwd")  //form中的密码输入框name  默认password
			.successHandler(myLoginSuccessHandler) //登录成功后执行
			.failureHandler(myLoginFailureHandler) //登录失败后执行
			.and()
		
		.logout()
			.logoutUrl("/logoutSubmit") //退出登录提交地址
			.logoutSuccessUrl("/logout") //退出后跳转地址
		.and()
		
		
		
		
		;
	  
	  
	  AuthenticationManager m = http.getSharedObject(AuthenticationManager.class);
	  System.out.println(m);
		
	}
}

/**
 * 这等同于以下 Spring Security xml 文件
 */
/*
<http auto-config="true">
<intercept-url pattern="/admin**" access="ROLE_ADMIN" />
<intercept-url pattern="/dba**" access="ROLE_ADMIN,ROLE_DBA" />
</http>

<authentication-manager>
<authentication-provider>
<user-service>
<user name="yiibai" password="123456" authorities="ROLE_USER" />
<user name="admin" password="123456" authorities="ROLE_ADMIN" />
<user name="dba" password="123456" authorities="ROLE_DBA" />
</user-service>
</authentication-provider>
</authentication-manager>
*/