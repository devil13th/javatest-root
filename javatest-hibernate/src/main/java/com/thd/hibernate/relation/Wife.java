package com.thd.hibernate.relation;

/**
 * Wife entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Wife implements java.io.Serializable {

	// Fields

	private Integer wifeId;
	private String wifeName;
	private Husband husbandId;

	// Constructors

	/** default constructor */
	public Wife() {
	}


	// Property accessors

	public Integer getWifeId() {
		return this.wifeId;
	}

	public void setWifeId(Integer wifeId) {
		this.wifeId = wifeId;
	}

	public String getWifeName() {
		return this.wifeName;
	}

	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}

	public Husband getHusbandId() {
		return this.husbandId;
	}

	public void setHusbandId(Husband husbandId) {
		this.husbandId = husbandId;
	}

}