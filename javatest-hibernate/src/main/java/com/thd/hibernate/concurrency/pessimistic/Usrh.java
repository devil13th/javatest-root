package com.thd.hibernate.concurrency.pessimistic;

/**
 * Usr entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Usrh implements java.io.Serializable {

	// Fields

	private String id;
	private String usr;
	private String pwd;
	private String nickname;
	
	// Constructors


	/** default constructor */
	public Usrh() {
	}


	/** full constructor */
	public Usrh(String usr, String pwd, String nickname) {
		this.usr = usr;
		this.pwd = pwd;
		this.nickname = nickname;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsr() {
		return this.usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}