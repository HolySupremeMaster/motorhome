package com.example.motorhomenordic.models;

public class Pickup {

    private int pickup_id;
    private int booking_id;
    private String pickup_date;
    private String pickup_location;


    public Pickup() {
    }

    public Pickup(int pickup_id, int booking_id, String pickup_date, String pickup_location) {
        this.pickup_id = pickup_id;
        this.booking_id = booking_id;
        this.pickup_date = pickup_date;
        this.pickup_location = pickup_location;
    }


    public int getPickup_id() {
        return pickup_id;
    }

    public void setPickup_id(int pickup_id) {
        this.pickup_id = pickup_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getPickup_location() {
        return pickup_location;
    }

    public void setPickup_location(String pickup_location) {
        this.pickup_location = pickup_location;
    }

    @Override
    public String toString() {
        return "Pickup{" +
                "pickup_id=" + pickup_id +
                ", booking_id=" + booking_id +
                ", pickup_date='" + pickup_date + '\'' +
                ", pickup_location='" + pickup_location + '\'' +
                '}';
    }
}
