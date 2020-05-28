package com.example.motorhomenordic.models;

public class Dropoff {
    private int dropoff_id;
    private int booking_id;
    private String dropoff_date;
    private String dropoff_location;

    public Dropoff() {
    }

    public Dropoff(int dropoff_id, int booking_id, String dropoff_date, String dropoff_location) {
        this.dropoff_id = dropoff_id;
        this.booking_id = booking_id;
        this.dropoff_date = dropoff_date;
        this.dropoff_location = dropoff_location;
    }


    public int getDropoff_id() {
        return dropoff_id;
    }

    public void setDropoff_id(int dropoff_id) {
        this.dropoff_id = dropoff_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getDropoff_date() {
        return dropoff_date;
    }

    public void setDropoff_date(String dropoff_date) {
        this.dropoff_date = dropoff_date;
    }

    public String getDropoff_location() {
        return dropoff_location;
    }

    public void setDropoff_location(String dropoff_location) {
        this.dropoff_location = dropoff_location;
    }

    @Override
    public String toString() {
        return "Dropoff{" +
                "dropoff_id=" + dropoff_id +
                ", booking_id=" + booking_id +
                ", dropoff_date='" + dropoff_date + '\'' +
                ", dropoff_location='" + dropoff_location + '\'' +
                '}';
    }
}
