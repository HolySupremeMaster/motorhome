package com.example.motorhomenordic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotorhomeDetailController {

    @GetMapping("/motorhomedetails1")
    public String motorhomedetails1(){
        return "motorhomePages/motorhomedetails1";
    }

    @GetMapping("/motorhomedetails2")
    public String motorhomedetails2(){
        return "motorhomePages/motorhomedetails2";
    }

    @GetMapping("/motorhomedetails3")
    public String motorhomedetails3(){
        return "motorhomePages/motorhomedetails3";
    }

    @GetMapping("/motorhomedetails4")
    public String motorhomedetails4(){
        return "motorhomePages/motorhomedetails4";
    }

    @GetMapping("/motorhomedetails5")
    public String motorhomedetails5(){
        return "motorhomePages/motorhomedetails5";
    }

    @GetMapping("/motorhomedetails6")
    public String motorhomedetails6(){
        return "motorhomePages/motorhomedetails6";
    }

    @GetMapping("/motorhomedetails7")
    public String motorhomedetails7(){
        return "motorhomePages/motorhomedetails7";
    }

    @GetMapping("/motorhomedetails8")
    public String motorhomedetails8(){
        return "motorhomePages/motorhomedetails8";
    }

}
