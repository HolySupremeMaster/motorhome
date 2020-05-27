package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.Address;
import com.example.motorhomenordic.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressRepositoryDB implements IAddressRepository{


    private Connection conn;

    public AddressRepositoryDB() {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createAddress(Address address) {



        try {

            // Indsætter addresse i databasen
            PreparedStatement addressStatement = conn.prepareStatement("INSERT INTO customer_address(address, zip, city) values(?, ?, ?) ");
            addressStatement.setString(1, address.getAddress());
            addressStatement.setInt(2, address.getZip());
            addressStatement.setString(3, address.getCity());

            addressStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
