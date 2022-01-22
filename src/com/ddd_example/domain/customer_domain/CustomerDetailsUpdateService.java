package com.ddd_example.domain.customer_domain;

import java.util.List;

public class CustomerDetailsUpdateService {
    public void updateCustomerAddress(Customer customer, Address newAddress) {
        customer.setAddress(newAddress);
        updateAccountsAddress(customer.getAccounts(), newAddress);
    }

    private void updateAccountsAddress(List<Account> accounts, Address newAddress) {
        accounts.forEach(account -> account.setAddress(newAddress));
    }
}
