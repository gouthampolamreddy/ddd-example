package com.ddd_example.application;

import com.ddd_example.domain.customer_domain.Account;
import com.ddd_example.domain.customer_domain.Address;
import com.ddd_example.domain.customer_domain.Customer;
import com.ddd_example.domain.customer_domain.CustomerDetailsUpdateService;

import java.util.List;

public class CustomerApp {
    public static void main(String[] args) {
        Address address = new Address("Chennai");
        List<Account> accounts = List.of(new Account("TESTID"));
        Customer customer = new Customer(address);
        customer.addAccounts(accounts);

        Address newAddress = new Address("Hyderabad");

        System.out.println(customer);

        CustomerDetailsUpdateService updateService = new CustomerDetailsUpdateService();
        updateService.updateCustomerAddress(customer, newAddress);

        System.out.println(customer);
    }
}
