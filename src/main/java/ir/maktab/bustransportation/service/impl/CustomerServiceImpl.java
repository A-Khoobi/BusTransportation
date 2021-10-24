package ir.maktab.bustransportation.service.impl;

import ir.maktab.bustransportation.domain.Customer;
import ir.maktab.bustransportation.repository.CustomerRepository;
import ir.maktab.bustransportation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        List<Customer> customers = customerRepository.findByUserName(customer.getUserName());
        if (customers.size() == 0) {
            customerRepository.save(customer);
            return customer;
        } else return null;
    }

    @Override
    public Customer logIn(Customer customer) {
        return null;
    }


}
