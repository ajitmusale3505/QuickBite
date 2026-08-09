package com.jsp.fdms.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.fdms.entity.FoodItem;
import com.jsp.fdms.entity.Order;
import com.jsp.fdms.entity.OrderItem;
import com.jsp.fdms.entity.Restaurant;
import com.jsp.fdms.entity.User;
import com.jsp.fdms.model.Cart;
import com.jsp.fdms.model.CartItem;
import com.jsp.fdms.repo.FoodItemRepo;
import com.jsp.fdms.repo.OrderRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	
	@Autowired
	FoodItemRepo foodRepo;
	
	@Autowired
	OrderRepo orderRepo;

	@PostMapping("/placeOrder")
	public String placeOrder(@RequestParam String paymentMethod,HttpSession session, Model model) {

	    Cart cart = (Cart) session.getAttribute("cart");

	    if (cart == null || cart.getItems().isEmpty()) {
	        return "redirect:/viewCart";
	    }
	    
	    User user = (User) session.getAttribute("user");

	    Order order = new Order();
	    order.setUser(user);
	    order.setPaymentMethod(paymentMethod);
	    order.setOrderTime(LocalDateTime.now());
	    order.setStatus("PLACED");

	    List<OrderItem> orderItems = new ArrayList<>();

	    double totalAmount = 0;
	    Restaurant restaurant = null;

	    for (CartItem ci : cart.getItems().values()) {

	        FoodItem food = foodRepo.findById(ci.getFoodId()).get();
	        
	        if (restaurant == null) {
	            restaurant = food.getRestaurant();
	        }

	        OrderItem oi = new OrderItem();
	        oi.setFoodItem(food);
	        oi.setQuantity(ci.getQuantity());
	        oi.setPrice(ci.getPrice());

	        totalAmount += ci.getPrice() * ci.getQuantity();

	        oi.setOrder(order);
	        orderItems.add(oi);
	    }

	    double gst = totalAmount * 0.05;
	    double delivery = 40;

	    order.setRestaurant(restaurant);  
	    order.setTotalAmount(totalAmount + gst + delivery);
	    order.setGst(gst);
	    order.setDeliveryCharge(delivery);
	    order.setOrderItems(orderItems);

	    orderRepo.save(order);

	    // ✅ IMPORTANT LINE (missing in your code)
	    model.addAttribute("order", order);

	    session.removeAttribute("cart");

	    return "order_success";
	}
	
	@GetMapping("/myOrders")
	public String myOrders(HttpSession session, Model model) {

	    User user = (User) session.getAttribute("user");

	    if (user == null) {
	        return "redirect:/login";
	    }

	    List<Order> orders = orderRepo.findByUser(user);

	    model.addAttribute("orders", orders);

	    return "my_orders";
	}
	
	@GetMapping("/checkout")
	public String checkout(HttpSession session, Model model) {

	    Cart cart = (Cart) session.getAttribute("cart");

	    if (cart == null || cart.getItems().isEmpty()) {
	        return "redirect:/viewCart";
	    }

	    double subtotal = cart.getTotalAmount();
	    double gst = subtotal * 0.05;
	    double delivery = 40;
	    double total = subtotal + gst + delivery;

	    model.addAttribute("subtotal", subtotal);
	    model.addAttribute("gst", gst);
	    model.addAttribute("delivery", delivery);
	    model.addAttribute("total", total);

	    return "checkout";
	}
}
