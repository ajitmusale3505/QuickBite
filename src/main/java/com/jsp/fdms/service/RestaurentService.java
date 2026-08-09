package com.jsp.fdms.service;

import java.util.List;

import com.jsp.fdms.entity.FoodItem;
import com.jsp.fdms.entity.Restaurant;
import com.jsp.fdms.entity.User;

public interface RestaurentService {

	public List<Restaurant> getAllRestaurent(); 
	public List<Restaurant> getByOwner(User owner);
	public Restaurant saveRestaurant(Restaurant restaurent);
	public List<Restaurant> searchRestaurants(String keyword);
	public Restaurant getRestaurant(int id);
	public List<FoodItem> getFoodItems(int restaurantId);
}
