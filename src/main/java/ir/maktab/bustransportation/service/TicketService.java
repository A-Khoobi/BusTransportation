package ir.maktab.bustransportation.service;

import ir.maktab.bustransportation.domain.Ticket;

public interface TicketService {
    Ticket save(Ticket ticket);

    Ticket getById(Integer id);
}
