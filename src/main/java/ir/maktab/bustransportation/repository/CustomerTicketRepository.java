package ir.maktab.bustransportation.repository;

import ir.maktab.bustransportation.domain.CustomerTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTicketRepository extends JpaRepository<CustomerTicket, Integer> {
}
