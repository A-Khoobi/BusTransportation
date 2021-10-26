package ir.maktab.bustransportation.controller;

import ir.maktab.bustransportation.domain.Customer;
import ir.maktab.bustransportation.domain.Location;
import ir.maktab.bustransportation.dto.TicketDto;
import ir.maktab.bustransportation.service.CustomerService;
import ir.maktab.bustransportation.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/Sign_up")
    public String displaySignUpForm(Customer customer, HttpSession session, Model model) {
        String massage = (String) session.getAttribute("massage");
        model.addAttribute("massage", massage);
        return "create-user";
    }


    @PostMapping("/create-user")
    public String addUser(Customer customer, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "create-user";
        }
        Customer customer1 = customerService.createCustomer(customer);
        if (customer1 == null) {
            String massage = "This User Exist!";
            session.setAttribute("massage", massage);
            return "redirect:/Sign_up";
        } else {
            session.removeAttribute("massage");
            return "redirect:/";
        }
    }


    @GetMapping("/Log-In")
    public String displayLogInForm(Customer customer, HttpSession session, Model model) {
        String massage = (String) session.getAttribute("massage");
        model.addAttribute("massage", massage);
        return "logInForm";
    }

    @PostMapping("/Log-In")
    public String logIn(Customer customer, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "create-user";
        }
        Customer ICustomer = customerService.logIn(customer);
        if (ICustomer != null) {
            session.setAttribute("customer", ICustomer);
            return "redirect:/User-Page";
        } else {
            String massage = "Wrong UserName Or PassWord";
            session.setAttribute("massage", massage);
            return "redirect:/Log-In";
        }


    }

    @GetMapping("/User-Page")
    public String displayUserPage(TicketDto ticketDto, Model model, HttpSession session) {
        List<Location> locations = locationService.getAllLocations();
        model.addAttribute("locations", locations);
        Customer customer = (Customer) session.getAttribute("customer");
        model.addAttribute(customer);
        return "User-Page";
    }

    @GetMapping("/passenger-form")
    public String displayPassengerForm(HttpServletRequest servletRequest, Model model) {
        String ticketID = servletRequest.getParameter("ticketId");
        model.addAttribute("ticketID", ticketID);
        return "passenger-form";
    }

}
