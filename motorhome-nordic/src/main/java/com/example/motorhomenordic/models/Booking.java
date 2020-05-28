package com.example.motorhomenordic.models;

public class Booking {

    private int booking_id;
    private String order_date;
    private boolean paid;
    private int customer_id;
    private int motorhome_id;
    private double total_price;



    public Booking() { }

    public Booking(int booking_id, String order_date, boolean paid, int customer_id, int motorhome_id) {
        this.booking_id = booking_id;
        this.order_date = order_date;
        this.paid = paid;
        this.motorhome_id = motorhome_id;
        this.customer_id = customer_id;
    }


    public int getBooking_id() { return booking_id; }

    public void setBooking_id(int booking_id) { this.booking_id = booking_id; }

    public String getOrder_date() { return order_date; }

    public void setOrder_date(String order_date) { this.order_date = order_date; }

    public boolean isPaid() { return paid; }

    public void setPaid(boolean paid) { this.paid = paid; }

    public int getCustomer_id() { return customer_id; }

    public void setCustomer_id(int customer_id) { this.customer_id = customer_id; }

    public int getMotorhome_id() { return motorhome_id; }

    public void setMotorhome_id(int motorhome_id) { this.motorhome_id = motorhome_id; }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", order_date='" + order_date + '\'' +
                ", paid=" + paid +
                ", customer_id=" + customer_id +
                ", motorhome_id=" + motorhome_id +
                '}';
    }
}
