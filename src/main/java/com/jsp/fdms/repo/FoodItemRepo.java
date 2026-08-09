package com.jsp.fdms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.fdms.entity.FoodItem;
import com.jsp.fdms.entity.Restaurant;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer>{

	List<FoodItem> findByRestaurantRestaurantId(int restaurantId);
}
