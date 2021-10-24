package ir.maktab.bustransportation.controller;

import ir.maktab.bustransportation.domain.Customer;
import ir.maktab.bustransportation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/Sign_up")
    public String displaySignUpForm(Customer customer) {
        return "create-user";
    }

    @PostMapping("/create-user")
    public String addUser(Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-user";
        }

        customerService.createCustomer(customer);
        return "redirect:/";
    }


}
