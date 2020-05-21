package com.example.motorhome.repositories;

import com.example.motorhome.models.Customer;

public interface ICostumerRepository {

    public void createCustomer(Customer customer);

    public boolean deleteCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

}