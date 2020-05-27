package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.Booking;
import com.example.motorhomenordic.util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingRepositoryDB implements IBookingRepository{

private Connection conn;
    public BookingRepositoryDB (){

        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createBooking(Booking booking) {
    try{
        PreparedStatement stmnt= conn.prepareStatement("INSERT INTO booking (costumer_id, motorhome_id, order_date, paid) values (?,?,?,?)");

        stmnt.setInt(1,booking.getCustomer_id());
        stmnt.setInt(2,booking.getMotorhome_id());
        stmnt.setString(3,booking.getOrder_date());
        stmnt.setBoolean(4,booking.isPaid());
        stmnt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    }
    }

    @Override
    public boolean deleteBooking(int booking_id) {
        PreparedStatement stmnt =null;

        try {
        stmnt =conn.prepareStatement("DELETE FROM booking WHERE booking_id=?");
        stmnt.setInt(1, booking_id);
        stmnt.executeUpdate();
        return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean updateBooking(Booking booking) {
        try {
            PreparedStatement stmnt = conn.prepareStatement("UPDATE booking SET booking_id=?, costumer_id=?, motorhome_id=?, order_date=?, paid=? WHERE booking_id = ?");

            stmnt.setInt(1,booking.getBooking_id());
            stmnt.setInt(2,booking.getCustomer_id());
            stmnt.setInt(3,booking.getMotorhome_id());
            stmnt.setString(4,booking.getOrder_date());
            stmnt.setBoolean(5,booking.isPaid());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        @Override
        public Booking getBooking (int  booking_id){
        Booking bookings = new Booking();
        try {
        PreparedStatement stmnt =conn.prepareStatement("SELECT * FROM booking where booking_id = ?");
        stmnt.setInt(1,booking_id);
            ResultSet rs= stmnt.executeQuery();

            while(rs.next()){
                bookings.setBooking_id(rs.getInt(1));
                bookings.setCustomer_id(rs.getInt(2));
                bookings.setMotorhome_id(rs.getInt(3));
                bookings.setOrder_date(rs.getString(4));
                bookings.setPaid(rs.getBoolean(5));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return bookings;
        }


    @Override
    public List<Booking> getAllBooking() {
List <Booking> bookingList = new ArrayList<>();

try {
    Statement statement =conn.createStatement();
    ResultSet rs =statement.executeQuery("SELECT * FROM booking");

    while(rs.next()){
        Booking bookings = new Booking();

        bookings.setBooking_id(rs.getInt(1));
        bookings.setCustomer_id(rs.getInt(2));
        bookings.setMotorhome_id(rs.getInt(3));
        bookings.setOrder_date(rs.getString(4));
        bookings.setPaid(rs.getBoolean(5));

        bookingList.add(bookings);
    }

} catch (Exception e) {
    e.printStackTrace();
}
        return bookingList;
    }
}
