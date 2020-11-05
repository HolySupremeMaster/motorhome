package com.example.motorhomenordic;

import com.example.motorhomenordic.models.Customer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {


   @Test
   public void getCustomer(){

       //Act
       ArrayList<Customer> list = new ArrayList<>();
       Customer customer = new Customer("Ali", "Raza", "Ali@Hotmail.com", 23434343, 1, 21, 1);
       list.add(customer);
       //Lægger penge på kontoen
       String expected = "Ali";
       String actual = list.get(0).getFirstName();
       //Assert
       assertEquals(expected, actual);


   }
}
