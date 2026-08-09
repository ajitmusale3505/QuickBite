package com.jsp.fdms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.fdms.entity.FoodItem;
import com.jsp.fdms.entity.Restaurant;
import com.jsp.fdms.entity.User;
import com.jsp.fdms.repo.FoodItemRepo;
import com.jsp.fdms.repo.RestaurentRepo;

@Service
public class RestaurentServiceImpl implements RestaurentService {

	@Autowired
	RestaurentRepo restRepo;

	@Autowired
	FoodItemRepo foodRepo;

	@Override
	public List<Restaurant> getAllRestaurent() {
		return restRepo.findAll();
	}

	@Override
	public List<Restaurant> getByOwner(User owner) {
		return restRepo.findByOwner(owner);
	}

	@Override
	public Restaurant saveRestaurant(Restaurant restaurent) {
		return restRepo.save(restaurent);
	}

	@Override
	public List<Restaurant> searchRestaurants(String keyword) {
		if (keyword == null || keyword.trim().isEmpty()) {
//	            throw new RuntimeException("Search keyword cannot be empty");
			return restRepo.findAll();
		}

		return restRepo.findByNameContainingIgnoreCase(keyword);
	}

	@Override
	public Restaurant getRestaurant(int id) {
		return restRepo.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
	}

	@Override
	public List<FoodItem> getFoodItems(int restaurantId) {
	    return foodRepo.findByRestaurantRestaurantId(restaurantId);
	}
}
