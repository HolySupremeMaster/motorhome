package com.example.motorhomenordic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotorhomeDetailController {

    @GetMapping("/motorhomedetails1")
    public String motorhomedetails1(){
        return "motorhomedetails1";
    }

}
