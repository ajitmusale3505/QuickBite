package com.jsp.fdms.service;

import com.jsp.fdms.entity.User;

public interface UserService {

	public User register(User user);
	User findByEmail(String email);
}
