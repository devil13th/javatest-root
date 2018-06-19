package com.thd.hibernate.relation;

/**
 * Husband entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Husband implements java.io.Serializable {

	// Fields

	private Integer husbandId;
	private String hasbandName;
	private Wife wifeId;

	// Constructors

	/** default constructor */
	public Husband() {
	}


	// Property accessors

	public Integer getHusbandId() {
		return this.husbandId;
	}

	public void setHusbandId(Integer husbandId) {
		this.husbandId = husbandId;
	}

	public String getHasbandName() {
		return this.hasbandName;
	}

	public void setHasbandName(String hasbandName) {
		this.hasbandName = hasbandName;
	}

	public Wife getWifeId() {
		return this.wifeId;
	}

	public void setWifeId(Wife wifeId) {
		this.wifeId = wifeId;
	}

}