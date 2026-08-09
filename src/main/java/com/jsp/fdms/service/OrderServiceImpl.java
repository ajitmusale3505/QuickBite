package com.jsp.fdms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.fdms.entity.Order;
import com.jsp.fdms.entity.User;
import com.jsp.fdms.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo orderRepo;

	@Override
	public List<Order> getOrdersByUser(User user) {
		 return orderRepo.findByUser(user);
	}
	
	
}
