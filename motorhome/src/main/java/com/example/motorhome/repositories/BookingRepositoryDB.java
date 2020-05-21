package com.example.motorhome.repositories;

import com.example.motorhome.models.Booking;
import com.example.motorhome.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookingRepositoryDB implements IBookingRepository{

private Connection conn;
    public BookingRepositoryDB (){

        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createBooking(Booking booking) {
    try{
        PreparedStatement stmnt= conn.prepareStatement("INSERT INTO booking (booking_id, costumer_id, motorhome_id, order_id, paid) values (?,?,?,?,?)");

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public boolean deleteBooking(Booking booking) {
        return false;
    }

    @Override
    public boolean updateBooking(Booking booking) {
        return false;
    }

    @Override
    public Booking getBooking(Booking bookingID) {
        return null;
    }

    @Override
    public List<Booking> getAllBooking() {
        return null;
    }
}
