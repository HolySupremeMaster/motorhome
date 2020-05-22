package com.example.motorhome.repositories;

import com.example.motorhome.models.Booking;
import com.example.motorhome.models.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICostumerRepository {

    public void createCustomer(Customer customer);

    public boolean deleteCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public Customer getCustomer (int customer_id);

    public List<Customer> getAllCustomer();

}