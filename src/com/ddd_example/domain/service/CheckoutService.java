package com.ddd_example.domain.service;

import com.ddd_example.domain.Cart;
import com.ddd_example.domain.CartItem;
import com.ddd_example.domain.Order;
import com.ddd_example.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutService {
    public Order checkoutAndOrder(Cart cart) {
        cart.checkout();
        List<CartItem> cartItems = cart.getCartItems();
        List<Product> productList = cartItems.stream().map(CartItem::getProduct).collect(Collectors.toList());
        return new Order(productList);
    }
}
