package com.example.motorhome.repositories;


import com.example.motorhome.models.Address;
import com.example.motorhome.models.Customer;
import com.example.motorhome.util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryDB implements ICostumerRepository {

    private Connection conn;

    public CustomerRepositoryDB() {

        this.conn = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createCustomer(Customer customer, Address address){



        try {

            // Indsætter addresse i databasen
            PreparedStatement addressStatement = conn.prepareStatement("INSERT INTO customer_address(address, zip, city) values(?, ?, ?) ");
            addressStatement.setString(1, address.getAddress());
            addressStatement.setInt(2, address.getZip());
            addressStatement.setString(3, address.getCity());

            // henter address_id
            PreparedStatement getAddress_id = conn.prepareStatement("SELECT * from customer_address where address_id = ?");
            getAddress_id.setInt(1, address.getAddress_id());

            ResultSet resultSet = getAddress_id.executeQuery();

            while (resultSet.next()){
                customer.setAddress_id(resultSet.getInt(1));
            }


            PreparedStatement stmnt = conn.prepareStatement("INSERT INTO customer(firstName, lastName, age, email, phonenumber, address_id) values (?,?,?,?,?,?)");
            stmnt.setString(1, customer.getFirstName());
            stmnt.setString(2, customer.getLastName());
            stmnt.setInt(3, customer.getAge());
            stmnt.setString(4, customer.getEmail());
            stmnt.setInt(5, customer.getPhonenumber());
            stmnt.setInt(6, customer.getAddress_id());
            stmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteCustomer(Customer customer_id) {
        PreparedStatement stmnt = null;
        try {
            stmnt = conn.prepareStatement("DELETE from customer where customer_id=?");
            stmnt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public boolean updateCustomer(Customer customer) {
        try {
            PreparedStatement stmnt = conn.prepareStatement("UPDATE customer set customer_id=?, firstname=?, lastname=?, age=?, email=?, phonenumber=?, address_id=?");
            stmnt.setInt(1, customer.getCustomer_id());
            stmnt.setString(2, customer.getFirstName());
            stmnt.setString(3, customer.getLastName());
            stmnt.setInt(4, customer.getAge());
            stmnt.setString(5, customer.getEmail());
            stmnt.setInt(6, customer.getPhonenumber());
            stmnt.setInt(7, customer.getAddress_id());
            stmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer getCustomer(int customer_id) {
        Customer customer = new Customer();

        try {
        PreparedStatement stmnt =conn.prepareStatement("SELECT * FROM customer where customer_id =?");
        stmnt.setInt(1,customer_id);
            ResultSet rs =stmnt.executeQuery();

            while (rs.next()){
            customer.setCustomer_id(rs.getInt(1));
            customer.setFirstName(rs.getString(2));
            customer.setLastName(rs.getString(3));
            customer.setAge(rs.getInt(4));
            customer.setEmail(rs.getString(5));
            customer.setPhonenumber(rs.getInt(6));
            customer.setAddress_id(rs.getInt(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {

        List <Customer>customerList = new ArrayList<>();

        try {
            Statement statement =conn.createStatement();
            ResultSet rs =statement.executeQuery("SELECT * FROM customer");

            while (rs.next()){
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setAge(rs.getInt(4));
                customer.setEmail(rs.getString(5));
                customer.setPhonenumber(rs.getInt(6));
                customer.setAddress_id(rs.getInt(7));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

}
