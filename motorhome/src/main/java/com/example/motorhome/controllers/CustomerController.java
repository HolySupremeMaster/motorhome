package com.example.motorhome.controllers;

import com.example.motorhome.models.Address;
import com.example.motorhome.models.Customer;
import com.example.motorhome.repositories.CustomerRepositoryDB;
import com.example.motorhome.repositories.ICostumerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    ICostumerRepository iCostumerRepository = new CustomerRepositoryDB();

    @GetMapping("/createcustomer")
    public String createCustomer(){



        return "createCustomer";
    }

    @PostMapping("/customercreated")
    public String created(@ModelAttribute Customer customer, @ModelAttribute Address address){

        iCostumerRepository.createCustomer(customer, address);

        return "redirect:/createbooking";
    }


}
