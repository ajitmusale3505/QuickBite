package com.jsp.fdms.entity;

import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	@ManyToOne
	private  User owner;
	private String name;
	private String address;
	private String city;
	private long phone;
	private LocalTime openTime;
	private LocalTime closeTime;
	private String rating;
	private double deliveryCharge;
	private boolean isactive;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<FoodItem> foodItems;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(User owner, String name, String address, String city, long phone,
			LocalTime openTime, LocalTime closeTime, String rating, double deliveryCharge, boolean isactive) {
		this.owner = owner;
		this.name = name;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.rating = rating;
		this.deliveryCharge = deliveryCharge;
		this.isactive = isactive;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
	
}
