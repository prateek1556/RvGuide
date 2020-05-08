package com.example.RvGuide.service;

import com.example.RvGuide.bean.RoleBean;
import com.example.RvGuide.bean.UserBean;
import com.example.RvGuide.model.Role;
import com.example.RvGuide.model.User;


public interface UserService {

	public void saveUser(UserBean user);
	
	public boolean isUserAlreadyPresent(UserBean user);
	
	public RoleBean findByRole(String role);
	
	public UserBean getUserByEmail(String email);
}
