package ir.maktab.bustransportation.repository;

import ir.maktab.bustransportation.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
