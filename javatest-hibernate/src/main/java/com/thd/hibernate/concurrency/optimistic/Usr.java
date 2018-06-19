package com.thd.hibernate.concurrency.optimistic;

/**
 * Usr entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Usr implements java.io.Serializable {

	// Fields

	private String id;
	private String usr;
	private String pwd;
	private String nickname;
	
	//乐观锁 版本控制
	private Integer v;
	// Constructors


	/** default constructor */
	public Usr() {
	}

	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
	}

	/** full constructor */
	public Usr(String usr, String pwd, String nickname) {
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