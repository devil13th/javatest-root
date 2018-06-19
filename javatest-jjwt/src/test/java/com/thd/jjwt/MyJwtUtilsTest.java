package com.thd.jjwt;

import io.jsonwebtoken.ExpiredJwtException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

import com.auth0.jwt.JWTExpiredException;
import com.thd.jjwt.bean.JwtClaims;
public class MyJwtUtilsTest extends TestCase{
	@Test
	public void testsign(){
		JwtClaims claim = new JwtClaims();
		long currentTime = System.currentTimeMillis();
		//签发时间
		claim.setIat(currentTime);
		//期限为20秒钟
		claim.setExpire(currentTime + 50000);
		//签发方
		claim.setIss("iss-devil13th");
		//被签发方
		claim.setAud("aud-devil13th");
		//秘钥
		claim.setSercurityStr("000000");
		Map m = new HashMap();
		m.put("name", "lwang1");
		m.put("pwd", "1234567");
		m.put("xxx", "test property");
		
		
		String str = MyJwtUtils.sign(claim, m);
		
		System.out.println(str);
		System.out.println("success");
	}
	
	
	@Test
	public void testverify() {
		try {
			JwtClaims claim = new JwtClaims();
			//签发方
			claim.setIss("iss-devil13th");
			//被签发方
			claim.setAud("aud-devil13th");
			//秘钥
			claim.setSercurityStr("000000");
			
			Map m = MyJwtUtils.parse(claim, "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0OTY1ODYxMTgsInh4eCI6InRlc3QgcHJvcGVydHkiLCJwd2QiOiIxMjM0NTY3IiwibmFtZSI6Imx3YW5nMSIsImF1ZCI6ImF1ZC1kZXZpbDEzdGgiLCJpc3MiOiJpc3MtZGV2aWwxM3RoIiwiaWF0IjoxNDk2NTg2MDY4fQ.yCTSoAC3Mf94AEiK7leUyePTvaWRuw0FXhoTpDBAwQk");
			System.out.println("--" + m);
		} catch (ExpiredJwtException e) {
			System.out.println("jwt 已过期");
		} catch(JWTExpiredException e){
			System.out.println("jwt 已过期");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAllProcess() throws Exception{
		JwtClaims claim = new JwtClaims();
		long currentTime = System.currentTimeMillis();
		//签发时间
		claim.setIat( currentTime);
		long expire = currentTime + 4000;
		//期限为5秒钟
		claim.setExpire(expire);
		//签发方
		claim.setIss("iss-devil13th");
		//被签发方
		claim.setAud("aud-devil13th");
		//秘钥
		claim.setSercurityStr("000000");
		Map m = new HashMap();
		m.put("name", "lwang");
		m.put("pwd", "123456");
		m.put("xxdd", "adsf");
		
		String str = MyJwtUtils.sign(claim, m);
		
		System.out.println("签发时间:" + new Date(currentTime));
		System.out.println("有效时间:" + new Date(expire));
		
		
		System.out.println(str);
		System.out.println("-----------------------------------------------");
		//Thread.sleep(3000);
		try {
			System.out.println("当前时间:" + new Date());
			System.out.println(MyJwtUtils.parse(claim, str));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
