package ir.maktab.bustransportation.controller;

import ir.maktab.bustransportation.domain.Customer;
import ir.maktab.bustransportation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

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
    public String displayLogInForm() {
        return "logInForm";
    }

    @PostMapping("/Log-In")
    public String logIn(Customer customer, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "create-user";
        }
        customerService.createCustomer(customer);
        return "redirect:/Sign_up";
    }


}
