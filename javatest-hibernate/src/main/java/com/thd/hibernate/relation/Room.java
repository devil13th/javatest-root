package com.thd.hibernate.relation;

import java.util.Set;

/**
 * Room entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Room implements java.io.Serializable {

	// Fields

	private Integer roomId;
	private String roomName;
	
	//persons 是 one to many 所用
	private Set<Person> persons;

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** full constructor */
	public Room(String roomName) {
		this.roomName = roomName;
	}

	// Property accessors

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

}