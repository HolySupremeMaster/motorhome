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
        PreparedStatement prepared = conn.prepareStatement("INSERT INTO booking(customer_id, motorhome_id, order_date, total_price ,paid) VALUES (?,?,?,?,?)");
        prepared.setInt(1, booking.getCustomer_id());
        prepared.setInt(2, booking.getMotorhome_id());
        prepared.setString(3, booking.getOrder_date());
        prepared.setDouble(4, booking.getTotal_price());
        prepared.setBoolean(5, booking.isPaid());

        prepared.executeUpdate();

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
            PreparedStatement stmnt = conn.prepareStatement("UPDATE booking SET motorhome_id = ?, order_date=?, paid=?, total_price=? WHERE booking_id = ?");

            stmnt.setInt(1, booking.getMotorhome_id());
            stmnt.setString(2, booking.getOrder_date());
            stmnt.setBoolean(3, booking.isPaid());
            stmnt.setDouble(4, booking.getTotal_price());
            stmnt.setInt(5, booking.getBooking_id());

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
                bookings.setTotal_price(rs.getDouble(5));
                bookings.setPaid(rs.getBoolean(6));

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
        bookings.setTotal_price(rs.getDouble(5));
        bookings.setPaid(rs.getBoolean(6));

        bookingList.add(bookings);
    }

} catch (Exception e) {
    e.printStackTrace();
}
        return bookingList;
    }


    @Override
    public int getLastBookingID() {

        int booking_id = 0;

        try{
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM booking");

            while (rs.next()){
                booking_id =  rs.getInt(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking_id;
    }
}
