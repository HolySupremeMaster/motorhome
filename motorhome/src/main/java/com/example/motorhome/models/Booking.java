package com.example.motorhome.models;

public class Booking {

    private int booking_id;
    private String order_date;
    private boolean paid;


    public Booking() { }

    public Booking(int booking_id, String order_date, boolean paid) {
        this.booking_id = booking_id;
        this.order_date = order_date;
        this.paid = paid;
    }

    public int getBooking_id() { return booking_id; }

    public void setBooking_id(int booking_id) { this.booking_id = booking_id; }

    public String getOrder_date() { return order_date; }

    public void setOrder_date(String order_date) { this.order_date = order_date; }

    public boolean isPaid() { return paid; }

    public void setPaid(boolean paid) { this.paid = paid; }

}
