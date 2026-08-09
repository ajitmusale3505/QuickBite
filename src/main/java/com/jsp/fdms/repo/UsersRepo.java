package com.jsp.fdms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.fdms.entity.User;

public interface UsersRepo extends JpaRepository<User, Integer>{

	User findByEmail(String email); 
}
