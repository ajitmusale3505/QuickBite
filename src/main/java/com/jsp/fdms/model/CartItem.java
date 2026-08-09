package com.jsp.fdms.model;

public class CartItem {

    private int foodId;
    private String name;
    private double price;
    private int quantity;
    private String img; 

    public CartItem() {}

     

	public CartItem(int foodId, String name, double price, int quantity, String img) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.img = img;
	}



	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}
	
	

    
}