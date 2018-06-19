package com.thd.jjwt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.auth0.jwt.internal.org.apache.commons.codec.binary.Hex;


public class SecurityUtils {
	public String hs256(String str) throws Exception{
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes("UTF-8"));
            String output = Hex.encodeHexString(hash);
            System.out.println(output);
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
	}
}
