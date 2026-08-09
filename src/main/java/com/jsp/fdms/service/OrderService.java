package com.jsp.fdms.service;

import java.util.List;

import com.jsp.fdms.entity.Order;
import com.jsp.fdms.entity.User;

public interface OrderService {

	List<Order> getOrdersByUser(User user);
}
