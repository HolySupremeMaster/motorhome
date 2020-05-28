package com.example.motorhomenordic.controllers;

import com.example.motorhomenordic.models.Customer;
import com.example.motorhomenordic.repositories.CustomerRepositoryDB;
import com.example.motorhomenordic.repositories.ICostumerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    ICostumerRepository iCostumerRepository = new CustomerRepositoryDB();

    @GetMapping ("/allcustomers")
    public String allCustomers(Model model){
        model.addAttribute("list",iCostumerRepository.getAllCustomer());
        return "allcustomers";
    }


        @GetMapping("/customerdetails{id}")
        public String customerDetails(@PathVariable("id") int customer_id, Model model) {

            Customer customer = iCostumerRepository.getCustomer(customer_id);

            model.addAttribute("customer_id", customer.getCustomer_id());
            model.addAttribute("firstName", customer.getFirstName());
            model.addAttribute("lastName", customer.getLastName());
            model.addAttribute("email", customer.getEmail());
            model.addAttribute("phoneNumber", customer.getPhonenumber());
            model.addAttribute("age", customer.getAge());
            model.addAttribute("address_id", customer.getAddress_id());

            return "customerdetails";
        }
    @GetMapping("/editcustomer{id}")
    public String edit(@PathVariable("id") int customer_id, Model model){

        Customer customer = iCostumerRepository.getCustomer(customer_id);

        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("lastName", customer.getLastName());
        model.addAttribute("email", customer.getEmail());
        model.addAttribute("phoneNumber", customer.getPhonenumber());
        model.addAttribute("age", customer.getAge());



        return "customeredit";
    }

    @PostMapping("/customeredited")
    public String edited(@ModelAttribute Customer customer){

        iCostumerRepository.updateCustomer(customer);

        return "redirect:/courses";
    }
}




