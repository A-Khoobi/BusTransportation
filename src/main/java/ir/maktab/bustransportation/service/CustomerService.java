package ir.maktab.bustransportation.service;

import ir.maktab.bustransportation.domain.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer logIn(Customer customer);


}
