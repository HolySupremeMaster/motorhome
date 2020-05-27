package com.example.motorhomenordic.controllers;

import com.example.motorhomenordic.models.Address;
import com.example.motorhomenordic.models.Booking;
import com.example.motorhomenordic.models.Customer;
import com.example.motorhomenordic.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingController {

    IBookingRepository iBookingRepository = new BookingRepositoryDB();



    ICostumerRepository iCostumerRepository = new CustomerRepositoryDB();
    IAddressRepository iAddressRepository = new AddressRepositoryDB();
    IMotorHomeRepository iMotorHomeRepository = new MotorHomeRepositoryDB();

    @GetMapping("/createcustomer")
    public String createCustomer(){

        return "createCustomer";
    }

    @PostMapping("/customercreated")
    public String created(@ModelAttribute Customer customer, @ModelAttribute Address address ){

        iAddressRepository.createAddress(address);
        iCostumerRepository.createCustomer(customer);

        return "redirect:/createbooking";
    }


    @GetMapping("/createbooking")
    public String createBooking(Model model){

        model.addAttribute("motorlist", iMotorHomeRepository.getAllMotorhome());



        return "createBooking";
    }

    @PostMapping("/created")
    public String created(@ModelAttribute Booking booking){
        iBookingRepository.createBooking(booking);
        
        return "redirect:/";
    }

}
