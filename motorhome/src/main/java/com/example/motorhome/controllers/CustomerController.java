package com.example.motorhome.controllers;

import com.example.motorhome.models.Address;
import com.example.motorhome.models.Customer;
import com.example.motorhome.repositories.AddressRepositoryDB;
import com.example.motorhome.repositories.CustomerRepositoryDB;
import com.example.motorhome.repositories.IAddressRepository;
import com.example.motorhome.repositories.ICostumerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    ICostumerRepository iCostumerRepository = new CustomerRepositoryDB();
    IAddressRepository iAddressRepository = new AddressRepositoryDB();

    @GetMapping("/createcustomer")
    public String createCustomer() {


        return "createCustomer";
    }

    @PostMapping("/customercreated")
    public String created(@ModelAttribute Customer customer, @ModelAttribute Address address) {

        iAddressRepository.createAddress(address);
        iCostumerRepository.createCustomer(customer);

        return "redirect:/createbooking";
    }

    @GetMapping("/customerDetails{id}")
    public String customerDetails(@PathVariable("id") int customer_id, Model model) {

        Customer customer = iCostumerRepository.getCustomer(customer_id);

        model.addAttribute("customer_id",customer.getCustomer_id());
        model.addAttribute("firstName",customer.getFirstName());
        model.addAttribute("lastName",customer.getLastName());
        model.addAttribute("email",customer.getEmail());
        model.addAttribute("phoneNumber",customer.getPhonenumber());
        model.addAttribute("age", customer.getAge());
        model.addAttribute("address_id",customer.getAddress_id());

        return "customer/details";
    }
}
