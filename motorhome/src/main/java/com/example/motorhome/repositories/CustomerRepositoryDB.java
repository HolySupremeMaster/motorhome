package com.example.motorhome.repositories;


import com.example.motorhome.models.Customer;
import com.example.motorhome.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepositoryDB implements ICostumerRepository {

    private Connection conn;

    public CustomerRepositoryDB() {

        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createCustomer(Customer customer){
        try {
            PreparedStatement stmnt = conn.prepareStatement("INSERT INTO custemor values (?,?,?,?,?,?,?)");
            stmnt.setInt(1, customer.getCustomerID());
            stmnt.setString(2, customer.getFirstName());
            stmnt.setString(3, customer.getLastName());
            stmnt.setInt(4, customer.getAge());
            stmnt.setString(5, customer.getEmail());
            stmnt.setInt(6, customer.getPhoneNumber());
            stmnt.setString(7, customer.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        PreparedStatement stmnt = null;
        try {
            stmnt = conn.prepareStatement("DELETE from customer where customer=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public boolean updateCustomer(Customer customer) {
        try {
            PreparedStatement stmnt = conn.prepareStatement("UPDATE customer set customer_id=?, firstname=?, lastname=?, age=?, email=?, phonenumber=?, address_id=?");
            stmnt.setInt(1, customer.getCustomerID());
            stmnt.setString(2, customer.getFirstName());
            stmnt.setString(3, customer.getLastName());
            stmnt.setInt(4, customer.getAge());
            stmnt.setString(5, customer.getEmail());
            stmnt.setInt(6, customer.getPhoneNumber());
            stmnt.setString(7, customer.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    }
