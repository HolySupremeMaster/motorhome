package com.example.motorhome.repositories;

import com.example.motorhome.models.Booking;

import java.util.List;

public interface IBookingRepository {


    public void createBooking (Booking booking);

    public boolean deleteBooking (Booking booking);

    public boolean updateBooking (Booking booking);

    public Booking getBooking (Booking bookingID);

    public List<Booking> getAllBooking();






}
