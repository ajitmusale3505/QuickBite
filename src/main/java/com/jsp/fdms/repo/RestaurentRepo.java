package com.jsp.fdms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.fdms.entity.Restaurant;
import com.jsp.fdms.entity.User;

public interface RestaurentRepo extends JpaRepository<Restaurant, Integer>{

	List<Restaurant> findByOwner(User owner);
	List<Restaurant> findByNameContainingIgnoreCase(String name);
	
}
