package com.example.motorhome.repositories;

import com.example.motorhome.models.Booking;

import java.util.List;

public interface IBookingRepository {


    public void createBooking (Booking booking);

    public boolean deleteBooking (int booking_id);

    public boolean updateBooking (Booking booking);

    public Booking getBooking (int booking_id);

    public List<Booking> getAllBooking();





}
