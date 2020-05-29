package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.Pickup;
import com.example.motorhomenordic.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PickupRepositoryDB implements IPickupRepository {

    private Connection conn;

    public PickupRepositoryDB() {
        conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createPickup(Pickup pickup) {


        try {
            PreparedStatement prePickup = conn.prepareStatement("INSERT INTO pickup(booking_id, pickup_date, pickup_location) VALUES (?,?,?)");
            prePickup.setInt(1, pickup.getBooking_id());
            prePickup.setString(2, pickup.getPickup_date());
            prePickup.setString(3, pickup.getPickup_location());

            prePickup.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Pickup getPickup(int booking_id) {

        Pickup pickup = new Pickup();


        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM pickup where booking_id = ?");
            preparedStatement.setInt(1, booking_id);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                pickup.setPickup_id(resultSet.getInt(1));
                pickup.setBooking_id(resultSet.getInt(2));
                pickup.setPickup_date(resultSet.getString(3));
                pickup.setPickup_location(resultSet.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pickup;
    }

    @Override
    public boolean updatePickup(Pickup pickup) {

        try {
            PreparedStatement prepared = conn.prepareStatement("UPDATE pickup set pickup_date=?, pickup_location=? where booking_id = ?");
            prepared.setString(1, pickup.getPickup_date());
            prepared.setString(2, pickup.getPickup_location());
            prepared.setInt(3, pickup.getBooking_id());

            prepared.executeUpdate();

            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deletePickup(int booking_id) {

        PreparedStatement prepared = null;
        try {
            prepared = conn.prepareStatement("DELETE FROM pickup WHERE Booking_id = ?");
            prepared.setInt(1, booking_id);

            prepared.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }
}
