package com.jsp.fdms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class FoodItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodId;
	@ManyToOne  
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	private String name;
	private String description;
	private String cateogry;
	private double price;
	private String img;
	private boolean isVage;
	private boolean isAvailable;
	private int preparationTime;
	
	public FoodItem() {
		// TODO Auto-generated constructor stub
	}

	public FoodItem(Restaurant restaurent, String name, String description,  String cateogry, double price,
			String img, boolean isVage, boolean isAvailable, int preparation_Time) {
		super();
		this.restaurant = restaurent;
		this.name = name;
		this.description = description;
		this.cateogry = cateogry;
		this.price = price;
		this.img = img;
		this.isVage = isVage;
		this.isAvailable = isAvailable;
		this.preparationTime = preparation_Time;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCateogry() {
		return cateogry;
	}

	public void setCateogry(String cateogry) {
		this.cateogry = cateogry;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public boolean isVage() {
		return isVage;
	}

	public void setVage(boolean isVage) {
		this.isVage = isVage;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparation_Time) {
		this.preparationTime = preparation_Time;
	}
	
	
}
