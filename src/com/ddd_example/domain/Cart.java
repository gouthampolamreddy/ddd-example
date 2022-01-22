package com.ddd_example.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private final List<CartItem> cartItems = new ArrayList<>();
    private final List<CartItem> removedCartItems = new ArrayList<>();

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    private boolean isCheckedOut = false;

    public void addToCart(CartItem... cartItems) {
        List<CartItem> cartItemList = Arrays.asList(cartItems);
        cartItemList.forEach(this::addToCart);
    }

    public void addToCart(CartItem cartItem) {
        List<CartItem> match = this.cartItems.stream().filter(item1 -> item1.equals(cartItem)).collect(Collectors.toList());
        if (match.size() > 0) {
            match.get(0).incrementQuantity(cartItem.getQuantity());
            int indexOfMatch = this.cartItems.indexOf(match.get(0));
            this.cartItems.remove(indexOfMatch);
            this.cartItems.add(indexOfMatch, match.get(0));
        } else {
            this.cartItems.add(cartItem);
        }
    }

    public void removeFromCart(CartItem cartItem) {
        int index = this.cartItems.indexOf(cartItem);
        CartItem removedCartItem = this.cartItems.get(index);
        addToRemovedList(removedCartItem);
        this.cartItems.remove(cartItem);
    }

    private void addToRemovedList(CartItem cartItem) {
        this.removedCartItems.add(cartItem);
    }

    public void summary() {
        System.out.println("=====Cart Summary=======");
        cartItems.forEach(System.out::println);
    }

    public void removedItemsSummary() {
        System.out.println("======Removed Cart Summary======");
        removedCartItems.forEach(System.out::println);
    }

    public void checkout() {
        this.isCheckedOut = true;
    }

    public List<CartItem> getCartItems() {
        return new ArrayList<>(this.cartItems);
    }
}
