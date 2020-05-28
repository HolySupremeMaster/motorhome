package com.example.motorhomenordic.controllers;

import com.example.motorhomenordic.models.Address;
import com.example.motorhomenordic.models.Booking;
import com.example.motorhomenordic.models.Customer;
import com.example.motorhomenordic.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

        Customer customer = iCostumerRepository.getLastCreatedCustomer();
        model.addAttribute("customer_id", customer.getCustomer_id());

        return "createBooking";
    }

    @PostMapping("/created")
    public String created(@ModelAttribute Booking booking){
        iBookingRepository.createBooking(booking);

        return "redirect:/";
    }


    @GetMapping ("/allbookings")
    public String allBookings(Model model){
        model.addAttribute("list",iBookingRepository.getAllBooking());
        model.addAttribute("motorlist", iMotorHomeRepository.getAllMotorhome());
        return "allbookings";
    }


    @GetMapping ("/bookingdetails{id}")
    public String bookingDetails(@PathVariable("id") int booking_id, Model model){
        Booking booking = iBookingRepository.getBooking(booking_id);

        Customer customer = iCostumerRepository.getCustomer(booking.getCustomer_id());

        model.addAttribute("booking_id", booking.getBooking_id());
        model.addAttribute("order_date", booking.getOrder_date());
        model.addAttribute("total_price", booking.getTotal_price());
        model.addAttribute("paid", booking.isPaid());
        model.addAttribute("motorhome_id", booking.getMotorhome_id());
        model.addAttribute("customer_id", booking.getCustomer_id());


        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("lastName", customer.getLastName());




        return "bookingdetails";
    }
    @GetMapping ("/editbooking{id}")
    public String editbooking(@PathVariable("id") int booking_id, Model model){


        Booking booking = iBookingRepository.getBooking(booking_id);


        model.addAttribute("booking_id", booking.getBooking_id());
        model.addAttribute("order_date", booking.getOrder_date());
        model.addAttribute("paid", booking.isPaid());
        model.addAttribute("motorhome_id", booking.getMotorhome_id());
        model.addAttribute("customer_id", booking.getCustomer_id());

        return "editbooking";


    }

    @PostMapping("/bookingedited")
    public String bookingedited(@ModelAttribute Booking booking){

        iBookingRepository.updateBooking(booking);

        return "redirect:/allbookings";
    }

    @GetMapping ("/deleteBookings{id}")
    public String deletebooking(@PathVariable("id") int booking_id){
        iBookingRepository.deleteBooking(booking_id);
        return"redirect:/allbookings";
    }
    @GetMapping("/motorhomedetails1")
    public String motorhomedetails1(){return "motorhomedetails1";}

}
