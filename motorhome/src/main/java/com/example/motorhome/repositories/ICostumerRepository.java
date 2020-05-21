package com.example.motorhome.repositories;

import com.example.motorhome.models.Customer;

import java.sql.SQLException;

public interface ICostumerRepository {

    public void createCustomer(Customer customer) throws SQLException;

    public boolean deleteCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

}