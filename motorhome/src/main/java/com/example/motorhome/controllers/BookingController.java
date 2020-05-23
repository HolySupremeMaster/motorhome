package com.example.motorhome.controllers;

import com.example.motorhome.models.Booking;
import com.example.motorhome.repositories.BookingRepositoryDB;
import com.example.motorhome.repositories.IBookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookingController {


    IBookingRepository iBookingRepository;

    public BookingController() {

        iBookingRepository = new BookingRepositoryDB();

    }

    @GetMapping("/createbooking")
    public String createBooking(){
        return "createBooking";
    }
    @PostMapping("/created")
    public String created(@ModelAttribute Booking booking){
    iBookingRepository.createBooking(booking);
    return "redirect:/createbooking";
    }



}
