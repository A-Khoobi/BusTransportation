package ir.maktab.bustransportation.controller;

import ir.maktab.bustransportation.domain.Ticket;
import ir.maktab.bustransportation.dto.CustomerTicketDto;
import ir.maktab.bustransportation.dto.TicketDto;
import ir.maktab.bustransportation.repository.LocationRepository;
import ir.maktab.bustransportation.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/add-customer-ticket")
    public String getPassengerInfo(HttpServletRequest request, CustomerTicketDto customerTicketDto, Model model) {
        Integer ticketId = Integer.valueOf(request.getParameter("ticketID"));
        String gender = request.getParameter("gender");
        String passengerName = request.getParameter("name");
        System.out.println(ticketId + gender + passengerName);

        return "add-customer-ticket";
    }

}

