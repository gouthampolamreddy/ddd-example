package com.ddd_example.domain.customer_domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Account> accounts = new ArrayList<>();
    private Address address;

    public Customer(Address address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addAccounts(List<Account> accounts) {
        accounts.forEach(account -> account.setAddress(this.address));
        this.accounts.addAll(accounts);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accounts=" + accounts +
                ", address=" + address +
                '}';
    }
}
