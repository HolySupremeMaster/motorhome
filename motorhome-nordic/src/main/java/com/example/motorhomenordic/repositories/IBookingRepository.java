package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.Booking;

import java.util.List;

public interface IBookingRepository {


    public void createBooking(Booking booking);

    public boolean deleteBooking(int booking_id);

    public boolean updateBooking(Booking booking);

    public Booking getBooking(int booking_id);

    public List<Booking> getAllBooking();





}
