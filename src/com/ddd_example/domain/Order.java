package com.ddd_example.domain;

import java.util.List;

public class Order {
    private final List<Product> productList;

    public Order(List<Product> productList) {
        this.productList = productList;
    }

    public void summary() {
        System.out.println("=====Order Summary======");
        productList.forEach(System.out::println);
    }
}
