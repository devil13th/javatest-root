package com.thd.jjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import junit.framework.TestCase;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;

public class Test extends TestCase {
	//加密解密方式一
	public void test01() throws Exception{
		//秘钥
		String tokenKey = "123456";
		
		//jwt使用的加密方式
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		 
		//当前时间
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		
		//使用的token_Key秘钥
		byte[] apiKeySecretBytes = tokenKey.getBytes();
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		//载荷信息
		Map myclaims = new HashMap();
		myclaims.put("name", "devil13th");
		myclaims.put("loginTime", new Date());
		/*
		sub: 该JWT所面向的用户
		iss: 该JWT的签发者
		iat(issued at): 在什么时候签发的token
		exp(expires): token什么时候过期
		nbf(not before)：token在此时间之前不能被接收处理
		jti：JWT ID为web token提供唯一标识
		*/
		myclaims.put("iss", "iss_devil13th");
		myclaims.put("iat", "iat___");
		myclaims.put("test", "test");
		myclaims.put("sss", "我是自定义属性");
		myclaims.put("aud", "audddd");
		
		//设置生成Claims
		JwtBuilder builder = Jwts.builder().setIssuedAt(now)
										.setClaims(myclaims)
		                                .setIssuer("devil13th2")
		                                .setAudience("www.devil13th.com")
		                                .signWith(signatureAlgorithm, signingKey);
		
		//注：JwtBuilder.setIssuer  与myclaims.put("iss", "iss_devil13th"); 操作的是同一个变量!!!
		//注：JwtBuilder.setAudience 与myclaims.put("aud", "audddd"); 操作的是同一个变量!!!
		
		//验证超时 让jwt超时 抛出 ExpiredJwtException 异常
		Thread.sleep(9000);
		
		
		//保持时间
		Long  ttlMillis = 5*1000L;
		
		//如果超时给出ExpiredJwtException异常
		if (ttlMillis >= 0) {
		    long expMillis = nowMillis + ttlMillis;
		    Date exp = new Date(expMillis);
		    builder.setExpiration(exp);
		}
		
		String jwtStr = builder.compact();
		System.out.println(jwtStr);
		
		
		
		// 解密方式一
		
		/* 第一个参数是密码 
		 * 第二个参数对应的是claims.put("aud", "audddd");
		 * 第三个参数对应的是claims.put("iss", issuer);
		 */
		final JWTVerifier verifier = new JWTVerifier(tokenKey, "www.devil13th.com","devil13th2");
		
		//final JWTVerifier verifier = new JWTVerifier(tokenKey);
	    final Map<String,Object> claimsMap = verifier.verify(jwtStr);
	    System.out.println(claimsMap);
	    
	    
	    
	    //解密方式二
	    Claims claims = Jwts.parser()        
	 		   .setSigningKey(tokenKey.getBytes())
	 		   .parseClaimsJws(jwtStr).getBody();
	    
	    System.out.println(claims);
	    
	    System.out.println(claims.get("iss"));
	    System.out.println(claims.getIssuer());
	}
	
	//加密解密方式二
	public void test02() throws Exception{
		//https://github.com/auth0/java-jwt
		final String issuer = "https://mydomain.com/";
		final String secret = "123456";

		final long iat = System.currentTimeMillis() /1000; // issued at claim 
		final long exp = iat + 3L; // expires claim. In this case the token expires in 3 seconds

		final JWTSigner signer = new JWTSigner(secret);
		final HashMap<String, Object> claims = new HashMap<String, Object>();
		/*
		sub: 该JWT所面向的用户
		iss: 该JWT的签发者
		aud:该JWT的被签发者
		iat(issued at): 在什么时候签发的token
		exp(expires): token什么时候过期
		nbf(not before)：token在此时间之前不能被接收处理
		jti：JWT ID为web token提供唯一标识
		
		*/
		claims.put("iss", issuer);
		claims.put("exp", exp); //单位是秒
		claims.put("iat", iat);
		claims.put("test", "test");
		claims.put("sss", "我是自定义属性");
		claims.put("aud", "audddd");
		
		final String jwt = signer.sign(claims);
		System.out.println(jwt);
		
		
		//验证超时 延时5秒 让jwt超时 抛出 ExpiredJwtException 异常
		Thread.sleep(1000);
		
		
		
		//Verify JWT (HS256)
		final String secret1 = "123456";
		try {
			/* 第一个参数是密码 
			 * 第二个参数对应的是claims.put("aud", "audddd");
			 * 第三个参数对应的是claims.put("iss", issuer);
			 */
		    final JWTVerifier verifier = new JWTVerifier(secret1,"audddd","https://mydomain.com/");
		    final Map<String,Object> claims1= verifier.verify(jwt);
		    System.out.println(claims1);
		} catch (JWTVerifyException e) {
			// Invalid Token
		   e.printStackTrace();
		}
		
		//Validate aud & iss claims
		final String secret2 = "123456";
		try {
		    //final JWTVerifier verifier = new JWTVerifier(secret2, "{{my-audience}}", "{{my-issuer}}");
		    
			
			/* 第一个参数是密码 
			 * 第二个参数对应的是claims.put("aud", "audddd");
			 * 第三个参数对应的是claims.put("iss", issuer);
			 */
			final JWTVerifier verifier = new JWTVerifier(secret2, "audddd", "https://mydomain.com/");
			   
		    final Map<String,Object> claims2= verifier.verify(jwt);
		    System.out.println(claims2);
		} catch (JWTVerifyException e) {
		    // Invalid Token
			 e.printStackTrace();
		}
	}
}
