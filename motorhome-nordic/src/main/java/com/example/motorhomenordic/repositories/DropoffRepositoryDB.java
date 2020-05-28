package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.Dropoff;
import com.example.motorhomenordic.models.Pickup;
import com.example.motorhomenordic.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DropoffRepositoryDB implements IDropoffRepository {

    private Connection conn;

    public DropoffRepositoryDB() {
        conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createDropoff(Dropoff dropoff) {

        PreparedStatement prePickup = null;
        try {
            prePickup = conn.prepareStatement("INSERT INTO dropoff(booking_id, dropoff_date, dropoff_location) VALUES (?,?,?)");
            prePickup.setInt(1, dropoff.getBooking_id());
            prePickup.setString(2, dropoff.getDropoff_date());
            prePickup.setString(3, dropoff.getDropoff_location());

            prePickup.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Dropoff getDropoff(int booking_id) {

        Dropoff dropoff = new Dropoff();


        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM dropoff where booking_id = ?");
            preparedStatement.setInt(1, booking_id);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                dropoff.setDropoff_id(resultSet.getInt(1));
                dropoff.setBooking_id(resultSet.getInt(2));
                dropoff.setDropoff_date(resultSet.getString(3));
                dropoff.setDropoff_location(resultSet.getString(4));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dropoff;
    }

    @Override
    public boolean updateDropoff(Dropoff dropoff) {

        try {
            PreparedStatement prepared = conn.prepareStatement("UPDATE dropoff set dropoff_date=?, dropoff_location=? where booking_id = ?");
            prepared.setString(1, dropoff.getDropoff_date());
            prepared.setString(2, dropoff.getDropoff_location());
            prepared.setInt(3, dropoff.getBooking_id());

            prepared.executeUpdate();

            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteDropoff(int booking_id) {

        PreparedStatement prepared = null;
        try {
            prepared = conn.prepareStatement("DELETE FROM dropoff WHERE Booking_id = ?");
            prepared.setInt(1, booking_id);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }
}
