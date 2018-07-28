package com.store.dao;

import java.util.List;

import com.store.bean.UserInfo;

public interface LoginDao {

	public UserInfo findUserInfo(String username);
	
	public List<String> getUserRoles(String username);
	
	public boolean registeruser(String username, String password);
	
}
