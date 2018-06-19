package com.thd.jjwt;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import sun.misc.BASE64Encoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thd.jjwt.bean.JwtClaims;
import com.thd.jjwt.bean.JwtHeader;
public class Test01 extends TestCase {
	@Test
	public void test(){
		JwtHeader jwtHeader = new JwtHeader();
		jwtHeader.setTyp("JWT");
		jwtHeader.setAlg("HS256");
		
		JwtClaims jwtClaims = new JwtClaims();
		jwtClaims.setIss("Online JWT Builder");
		jwtClaims.setExpire(1448333419);
		jwtClaims.setAud("www.example.com");
		jwtClaims.setSub("jrocket@example.com");
		
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String jwtClaimsJsonStr = gson.toJson(jwtClaims);
		String jwtHeaderJsonStr = gson.toJson(jwtHeader);
		System.out.println(jwtClaimsJsonStr);
		System.out.println("---------------------------------------------");
		System.out.println(jwtHeaderJsonStr);
		System.out.println("---------------------------------------------");
		
		String jwtClaimsStr = new BASE64Encoder().encode(jwtClaimsJsonStr.getBytes());
		String jwtHeaderStr = new BASE64Encoder().encode(jwtHeaderJsonStr.getBytes());
		System.out.println(jwtClaimsStr);
		System.out.println("---------------------------------------------");
		System.out.println(jwtHeaderStr);
		System.out.println("---------------------------------------------");
		
		
		String body = jwtHeaderStr + "." + jwtClaimsStr;
		
	}
}
