package com.thd.activiti.idbean;

import org.activiti.engine.identity.User;

public class MyUser implements User {
	
	private String email;
	private String firstName;
	private String id;
	private String lastName;
	private String password;
	
	public MyUser(String id) {
		super();
		this.id = id;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isPictureSet() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setEmail(String arg0) {
		// TODO Auto-generated method stub

	}

	public void setFirstName(String arg0) {
		// TODO Auto-generated method stub

	}

	public void setId(String arg0) {
		// TODO Auto-generated method stub

	}

	public void setLastName(String arg0) {
		// TODO Auto-generated method stub

	}

	public void setPassword(String arg0) {
		// TODO Auto-generated method stub

	}

}
