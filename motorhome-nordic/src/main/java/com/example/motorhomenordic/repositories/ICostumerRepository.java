package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.Customer;

import java.util.List;

public interface ICostumerRepository {

    public void createCustomer(Customer customer);


    public boolean deleteCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public Customer getCustomer(int customer_id);

    public Customer getLastCreatedCustomer();

    public List<Customer> getAllCustomer();

}