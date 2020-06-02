package com.example.motorhomenordic.controllers;

import com.example.motorhomenordic.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login/login";
    }



}
