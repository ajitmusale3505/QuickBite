package com.jsp.fdms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.fdms.entity.Order;
import com.jsp.fdms.entity.User;

public interface OrderRepo extends JpaRepository<Order, Integer>{

	List<Order> findByUser(User user);
}
