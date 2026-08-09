package com.jsp.fdms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.fdms.entity.FoodItem;
import com.jsp.fdms.model.Cart;
import com.jsp.fdms.model.CartItem;
import com.jsp.fdms.repo.FoodItemRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	FoodItemRepo foodRepo;

	@PostMapping("/addToCart")
	public String addToCart(
	        @RequestParam int foodId,
	        @RequestParam int quantity,
	        HttpSession session) {
		
		if (quantity <= 0) {
	        quantity = 1;
	    }

	    Cart cart = (Cart) session.getAttribute("cart");

	    if (cart == null) {
	        cart = new Cart();
	    }

	    FoodItem item = foodRepo.findById(foodId).get();

	    CartItem cartItem = new CartItem(
	            item.getFoodId(),
	            item.getName(),
	            item.getPrice(),
	            quantity,
	            item.getImg() 
	    );

	    cart.addItem(cartItem);

	    session.setAttribute("cart", cart);
	    
	    System.out.println("FoodId: " + foodId);
	    System.out.println("Quantity: " + quantity);

	    return "redirect:/viewCart";
	}
	
	
	@GetMapping("/viewCart")
	public String viewCart(HttpSession session, Model model) {

	    Cart cart = (Cart) session.getAttribute("cart");

	    if (cart == null) {
	        cart = new Cart();
	    }

	    double subtotal = cart.getTotalAmount();
	    double gst = subtotal * 0.05; // 5%
	    double delivery = 40;

	    double total = subtotal + gst + delivery;

	    model.addAttribute("cart", cart);
	    model.addAttribute("subtotal", subtotal);
	    model.addAttribute("gst", gst);
	    model.addAttribute("delivery", delivery);
	    model.addAttribute("total", total);

	    return "cart";
	}
	
	@GetMapping("/removeItem")
	public String removeItem(@RequestParam int foodId, HttpSession session) {

	    Cart cart = (Cart) session.getAttribute("cart");

	    if (cart != null) {
	        cart.removeItem(foodId);
	    }

	    return "redirect:/viewCart";
	}
	
	@GetMapping("/increaseQty")
	public String increaseQty(@RequestParam int foodId, HttpSession session) {

	    Cart cart = (Cart) session.getAttribute("cart");

	    if (cart != null) {
	        cart.increaseQuantity(foodId);
	    }

	    return "redirect:/viewCart";
	}
	
	@GetMapping("/decreaseQty")
	public String decreaseQty(@RequestParam int foodId, HttpSession session) {

	    Cart cart = (Cart) session.getAttribute("cart");

	    if (cart != null) {
	        cart.decreaseQuantity(foodId);
	    }

	    return "redirect:/viewCart";
	}
}
