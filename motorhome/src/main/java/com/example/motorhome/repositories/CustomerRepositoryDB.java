package com.example.motorhome.repositories;


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
    public void createCustomer(Customer customer){
        try {
            PreparedStatement stmnt = conn.prepareStatement("INSERT INTO customer values (?,?,?,?,?,?,?)");
            stmnt.setInt(1, customer.getCustomer_id());
            stmnt.setString(2, customer.getFirstName());
            stmnt.setString(3, customer.getLastName());
            stmnt.setInt(4, customer.getAge());
            stmnt.setString(5, customer.getEmail());
            stmnt.setInt(6, customer.getPhonenumber());
            stmnt.setString(7, customer.getAddress_id());
            stmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        PreparedStatement stmnt = null;
        try {
            stmnt = conn.prepareStatement("DELETE from customer where customer=?");
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
            stmnt.setString(7, customer.getAddress_id());
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
            customer.setAddress_id(rs.getString(7));
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
                customer.setAddress_id(rs.getString(7));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

}
