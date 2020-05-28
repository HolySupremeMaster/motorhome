package com.example.motorhomenordic.controllers;

import com.example.motorhomenordic.models.Booking;
import com.example.motorhomenordic.repositories.BookingRepositoryDB;
import com.example.motorhomenordic.repositories.IBookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {



    @GetMapping("/")
    public String index(){
        return "homePage";
    }




}


