package ir.maktab.bustransportation.service.impl;

import ir.maktab.bustransportation.domain.Customer;
import ir.maktab.bustransportation.repository.CustomerRepository;
import ir.maktab.bustransportation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customer1 = customerRepository.findByUserName(customer.getUserName());
        if (customer1 == null) {
            customerRepository.save(customer);
            return customer;
        } else return null;
    }

    @Override
    public Customer logIn(Customer customer) {
        Customer customer1 = customerRepository.findByUserName(customer.getUserName());
        if (customer1 != null && customer.getPassWord().equals(customer1.getPassWord())) {
            return customer1;
        } else {
            return null;
        }
    }


}
