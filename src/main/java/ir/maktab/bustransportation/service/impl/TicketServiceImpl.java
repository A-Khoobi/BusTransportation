package ir.maktab.bustransportation.service.impl;

import ir.maktab.bustransportation.domain.Ticket;
import ir.maktab.bustransportation.repository.TicketRepository;
import ir.maktab.bustransportation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;


    @Override
    public Ticket save(Ticket ticket) {
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public Ticket getById(Integer id) {
        return ticketRepository.getById(id);
    }
}
