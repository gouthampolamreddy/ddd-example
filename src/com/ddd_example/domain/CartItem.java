package com.ddd_example.domain;

import java.util.Objects;

public class CartItem {
    private Product product;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Product product) {
        this(product, 1);
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return product.equals(cartItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
