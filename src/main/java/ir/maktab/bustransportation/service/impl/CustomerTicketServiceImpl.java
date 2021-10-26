package ir.maktab.bustransportation.service.impl;

import ir.maktab.bustransportation.domain.Customer;
import ir.maktab.bustransportation.domain.CustomerTicket;
import ir.maktab.bustransportation.repository.CustomerTicketRepository;
import ir.maktab.bustransportation.service.CustomerTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTicketServiceImpl implements CustomerTicketService {

    @Autowired
    CustomerTicketRepository customerTicketRepository;

    @Override
    public CustomerTicket save(CustomerTicket customerTicket) {
        customerTicketRepository.save(customerTicket);
        return customerTicket;
    }

    @Override
    public List<CustomerTicket> findByCustomer(Customer customer) {
        return customerTicketRepository.findByCustomer(customer);
    }

    @Override
    public CustomerTicket getById(Integer id) {
        return customerTicketRepository.getById(id);
    }

    @Override
    public void remove(Integer id) {
        customerTicketRepository.deleteById(id);
    }
}
