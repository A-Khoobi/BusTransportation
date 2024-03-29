package ir.maktab.bustransportation.controller;

import ir.maktab.bustransportation.domain.Customer;
import ir.maktab.bustransportation.domain.CustomerTicket;
import ir.maktab.bustransportation.domain.Ticket;
import ir.maktab.bustransportation.dto.CustomerTicketDto;
import ir.maktab.bustransportation.dto.TicketDto;
import ir.maktab.bustransportation.repository.LocationRepository;
import ir.maktab.bustransportation.repository.TicketRepository;
import ir.maktab.bustransportation.service.CustomerTicketService;
import ir.maktab.bustransportation.service.TicketService;
import ir.maktab.bustransportation.service.comprator.TimeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CustomerTicketService customerTicketService;


    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tickets")
    public String displayTicketList(TicketDto ticketDto, Model model) {
        List<Ticket> tickets = ticketRepository.findtickets(ticketDto.getOriginID(), ticketDto.getDestinationID(), ticketDto.getDate());
        tickets.sort(new TimeComparator());
        String origin = locationRepository.getById(ticketDto.getOriginID()).getName();
        String destination = locationRepository.getById(ticketDto.getDestinationID()).getName();
        model.addAttribute("origin", origin);
        model.addAttribute("destination", destination);
        model.addAttribute("tickets", tickets);
        model.addAttribute("date", ticketDto.getDate());
        return "show-tickets";
    }

    @GetMapping("/add-customer-ticket")
    public String getPassengerInfo(HttpSession session, HttpServletRequest request, CustomerTicketDto customerTicketDto, Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        Integer ticketId = Integer.valueOf(request.getParameter("ticketID"));
        String gender = request.getParameter("gender");
        String passengerName = request.getParameter("name");
//        System.out.println(customer.getUserName() + ticketId + gender + passengerName);
        CustomerTicket customerTicket = new CustomerTicket();
        customerTicket.setCustomer(customer);
        customerTicket.setGender(gender);
        customerTicket.setPassenger(passengerName);
        customerTicket.setTicket(ticketService.getById(ticketId));
        customerTicketService.save(customerTicket);

        String sex;
        if (gender.equals("مرد")) sex = "آقای";
        else sex = "خانم";

        String massage = sex + " " + passengerName + " " + "خرید بلیط شما با موفقیت انجام شد.";
        model.addAttribute("massage", massage);
        return "add-customer-ticket";
    }

    @GetMapping("/customers-ticket")
    public String displayCustomerTickets(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        List<CustomerTicket> customerTickets = customerTicketService.findByCustomer(customer);
        model.addAttribute("tickets", customerTickets);
        return "customers-ticket";
    }

    @GetMapping("/ticket-detail")
    public String displaySingleTicket(HttpServletRequest request, Model model) {
        Integer ticketID = Integer.valueOf(request.getParameter("ticketId"));
        CustomerTicket customerTicket = customerTicketService.getById(ticketID);
        CustomerTicketDto t = new CustomerTicketDto();
        t.setTicketId(customerTicket.getTicket().getId());
        t.setPassengerName(customerTicket.getPassenger());
        t.setGender(customerTicket.getGender());
        t.setOrigin(customerTicket.getTicket().getOriginLocation().getName());
        t.setDestination(customerTicket.getTicket().getDestinationLocation().getName());
        t.setDate(customerTicket.getTicket().getDate());
        t.setTime(customerTicket.getTicket().getTime());
        t.setTripID(customerTicket.getTicket().getTripId());
        t.setCustomerTicketId(ticketID);
        model.addAttribute("ticket", t);
        return "ticket-detail";
    }

    @PostMapping("/remove-ticket")
    public String removeTicket(HttpServletRequest request, Model model) {
        System.out.println(request.getParameter("removeID"));
        Integer id = Integer.valueOf(request.getParameter("removeID"));
        customerTicketService.remove(id);
        return "redirect:/User-Page";
    }

}

