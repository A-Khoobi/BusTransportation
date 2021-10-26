package ir.maktab.bustransportation.repository;

import ir.maktab.bustransportation.domain.Customer;
import ir.maktab.bustransportation.domain.CustomerTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerTicketRepository extends JpaRepository<CustomerTicket, Integer> {
    List<CustomerTicket> findByCustomer(Customer customer);

}
