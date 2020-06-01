package com.example.motorhomenordic.controllers;

import com.example.motorhomenordic.models.Address;
import com.example.motorhomenordic.models.Customer;
import com.example.motorhomenordic.repositories.AddressRepositoryDB;
import com.example.motorhomenordic.repositories.CustomerRepositoryDB;
import com.example.motorhomenordic.repositories.IAddressRepository;
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
    IAddressRepository iAddressRepository = new AddressRepositoryDB();

    @GetMapping("/createcustomer")
    public String createCustomer(){

        return "customer/createCustomer";
    }

    @PostMapping("/customercreated")
    public String created(@ModelAttribute Customer customer, @ModelAttribute Address address ){

        iAddressRepository.createAddress(address);
        iCostumerRepository.createCustomer(customer);

        return "redirect:/createbooking";
    }

    @GetMapping ("/allcustomers")
    public String allCustomers(Model model){
        model.addAttribute("list",iCostumerRepository.getAllCustomer());
        return "customer/allcustomers";
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

            return "customer/customerdetails";
        }
    @GetMapping("/editcustomer{id}")
    public String edit(@PathVariable("id") int customer_id, Model model){

        Customer customer = iCostumerRepository.getCustomer(customer_id);
        model.addAttribute("customer_id",customer.getCustomer_id());
        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("lastName", customer.getLastName());
        model.addAttribute("email", customer.getEmail());
        model.addAttribute("phonenumber", customer.getPhonenumber());
        model.addAttribute("age", customer.getAge());



        return "customer/customeredit";
    }

    @PostMapping("/customeredited")
    public String edited(@ModelAttribute Customer customer){

        iCostumerRepository.updateCustomer(customer);

        return "redirect:/allcustomers";
    }
    @GetMapping ("/deletecustomer{id}")
    public String deleteCustomer(@PathVariable ("id") int customer_id){

        iCostumerRepository.deleteCustomer(customer_id);

        return "redirect:/allcustomers";
    }
}




