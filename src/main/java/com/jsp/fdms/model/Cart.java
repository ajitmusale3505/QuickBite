package com.jsp.fdms.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items = new HashMap<>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        if (items.containsKey(item.getFoodId())) {
            CartItem existing = items.get(item.getFoodId());
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
        } else {
            items.put(item.getFoodId(), item);
        }
    }

    public void removeItem(int foodId) {
        items.remove(foodId);
    }

    public double getTotalAmount() {
        return items.values().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
    
    public void increaseQuantity(int foodId) {
        if (items.containsKey(foodId)) {
            CartItem item = items.get(foodId);
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    public void decreaseQuantity(int foodId) {
        if (items.containsKey(foodId)) {
            CartItem item = items.get(foodId);
            int qty = item.getQuantity();

            if (qty <= 1) {
                items.remove(foodId); // remove if 0
            } else {
                item.setQuantity(qty - 1);
            }
        }
    }

}