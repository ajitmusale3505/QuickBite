package com.jsp.fdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.fdms.entity.FoodItem;
import com.jsp.fdms.entity.Restaurant;
import com.jsp.fdms.entity.User;
import com.jsp.fdms.service.RestaurentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RestaurentController {

	@Autowired
	RestaurentService restServ;
	
	@PostMapping("/saveRestaurant")
	public String saveRestaurant(@ModelAttribute Restaurant restaurant, HttpSession session) {

	    User owner = (User) session.getAttribute("user");
 
	    restaurant.setOwner(owner);   

	    restServ.saveRestaurant(restaurant);

	    return "redirect:/owner_dashboard";
	}
	
	@GetMapping("/owner_dashboard")
	public String ownerDashboard() {
	    return "owner_dashboard";
	}
	
	@PostMapping("/search")
	public String searchRestaurent(@RequestParam String restaurent_Name,Model model) {
		List<Restaurant> searchRestaurants = restServ.searchRestaurants(restaurent_Name);
		model.addAttribute("restaurants", searchRestaurants);
		return "user_dashboard";
	}
	
	@GetMapping("/viewMenu")
	public String viewMenu(@RequestParam int restaurantId, Model model) {

	    Restaurant restaurant = restServ.getRestaurant(restaurantId);
	    List<FoodItem> items = restServ.getFoodItems(restaurantId);
	    
	    System.out.println("Items size: " + items.size());

	    // optional deeper debug (very useful)
	    for(FoodItem f : items){
	        System.out.println("Name: " + f.getName() + ", Price: " + f.getPrice());
	    }


	    model.addAttribute("restaurant", restaurant);
	    model.addAttribute("foodItems", items);

	    return "restaurant_menu";
	}
} 
