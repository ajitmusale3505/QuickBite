package com.jsp.fdms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.fdms.entity.User;
import com.jsp.fdms.repo.UsersRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UsersRepo repo;

	@Override
	public User register(User u) {
		 User user = repo.save(u);
		 return user;
	}

	@Override
	public User findByEmail(String email) {
		return  repo.findByEmail(email);
	}
	
}
