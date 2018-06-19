package com.thd.proxy;

public class UserManagerImpl implements UserManager {

	public String addUsr(String usr) {
		System.out.println("[UserManagerImpl.addUsr]" + usr);
		return usr + "|123456";
	}

	public String deleteUsr(String usr) {
		System.out.println("[UserManagerImpl.deleteUsr] " + usr);
		return usr + "delete";
	}

}
