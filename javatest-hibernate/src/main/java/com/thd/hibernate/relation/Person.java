package com.thd.hibernate.relation;

/**
 * Person entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Person implements java.io.Serializable {

	// Fields

	private Integer personId;
	private String personName;
	
	//many to one 所用 设置person所属room
	private Room roomId;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** full constructor */

	// Property accessors

	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Room getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

}