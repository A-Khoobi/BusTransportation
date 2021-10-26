package ir.maktab.bustransportation.service;

import ir.maktab.bustransportation.domain.Customer;
import ir.maktab.bustransportation.domain.CustomerTicket;

import java.util.List;

public interface CustomerTicketService {

    CustomerTicket save(CustomerTicket customerTicket);

    List<CustomerTicket> findByCustomer(Customer customer);
}
