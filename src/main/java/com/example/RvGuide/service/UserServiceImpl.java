package com.example.RvGuide.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RvGuide.bean.RoleBean;
import com.example.RvGuide.bean.UserBean;
import com.example.RvGuide.dao.RoleRepository;
import com.example.RvGuide.dao.UserRepository;
import com.example.RvGuide.model.Role;
import com.example.RvGuide.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(UserBean userBean) {
		userBean.setPassword(encoder.encode(userBean.getPassword()));
		userBean.setStatus("VERIFIED");
		Role userRole = roleRepository.findByRole("SITE_USER");
		System.out.println("userRole+++++++++"+userRole);
		userBean.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		User userEntity = new User();
		BeanUtils.copyProperties(userBean,userEntity);// --->
		
		userRepository.save(userEntity);
	}

	@Override
	public boolean isUserAlreadyPresent(UserBean user) {
		// Try to implement this method, as assignment.
		return false;
	}

	@Override
	public RoleBean findByRole(String role) {
		Role x = roleRepository.findByRole(role);
		RoleBean roleBean = new RoleBean();
		BeanUtils.copyProperties(x,roleBean);
		System.out.println("This is role +++++++++++ "+roleBean);
		return roleBean;
	}

	@Override
	public UserBean getUserByEmail(String email) {
		User userEntity = userRepository.getUserByEmail(email);
		UserBean userBean = new UserBean();
		BeanUtils.copyProperties(userEntity,userBean);
		return userBean;
	}

	

}
