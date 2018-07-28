package com.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.store.bean.UserInfo;
import com.store.dao.LoginDao;


@Service
public class LoginService implements UserDetailsService{

	
	@Autowired
	private LoginDao loginDao;
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo user = loginDao.findUserInfo(username);
		
		if(user == null){
			throw new UsernameNotFoundException("user name does not exist");
		}
		
		List<String> roles = loginDao.getUserRoles(username);
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if(roles != null){
			for(String role : roles){
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		
		
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantList);
		
		return userDetails;
	}
	
	public boolean registeruser(String username , String password){
		
		return loginDao.registeruser(username, password);
	}
	
}
