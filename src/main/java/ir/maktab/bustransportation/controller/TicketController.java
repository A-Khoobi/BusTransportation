package ir.maktab.bustransportation.controller;

import ir.maktab.bustransportation.domain.Ticket;
import ir.maktab.bustransportation.dto.TicketDto;
import ir.maktab.bustransportation.repository.LocationRepository;
import ir.maktab.bustransportation.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private LocationRepository locationRepository;


    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tickets")
    public String displayTicketList(TicketDto ticketDto, Model model) {
        List<Ticket> tickets = ticketRepository.findtickets(ticketDto.getOriginID(), ticketDto.getDestinationID(), ticketDto.getDate());
        String origin = locationRepository.getById(ticketDto.getOriginID()).getName();
        String destination = locationRepository.getById(ticketDto.getDestinationID()).getName();
        model.addAttribute("origin", origin);
        model.addAttribute("destination", destination);
        model.addAttribute("tickets", tickets);
        model.addAttribute("date", ticketDto.getDate());
        return "show-tickets";
    }

}

