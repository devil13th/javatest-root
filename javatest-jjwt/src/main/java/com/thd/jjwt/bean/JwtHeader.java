package com.thd.jjwt.bean;
/**
 * jwt header bean for json
 */
public class JwtHeader {
	//token 类型
	private String typ;
	//加密算法
	private String alg;
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getAlg() {
		return alg;
	}
	public void setAlg(String alg) {
		this.alg = alg;
	}
	
}
