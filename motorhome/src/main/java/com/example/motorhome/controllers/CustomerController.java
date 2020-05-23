package com.example.motorhome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/createcustomer")
    public String createCustomer(){
        return "createCustomer";
    }

    @PostMapping("/customercreated")
    public String created(){

        return "redirect:/createbooking";
    }


}
