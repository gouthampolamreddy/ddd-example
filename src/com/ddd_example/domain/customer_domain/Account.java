package com.ddd_example.domain.customer_domain;

public class Account {
    private final String id;
    private Address address;

    public Account(String id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", address=" + address +
                '}';
    }
}
