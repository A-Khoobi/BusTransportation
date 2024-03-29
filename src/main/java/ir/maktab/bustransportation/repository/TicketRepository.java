package ir.maktab.bustransportation.repository;

import ir.maktab.bustransportation.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("select t from Ticket t where t.originLocation.id = :OID and t.destinationLocation.id=:DID and t.date= :date ")
    List<Ticket> findtickets(@Param("OID") Integer OID, @Param("DID") Integer DID, @Param("date") LocalDate date);
}