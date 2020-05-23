package com.example.motorhome;

import com.example.motorhome.models.Booking;
import com.example.motorhome.repositories.BookingRepositoryDB;
import com.example.motorhome.util.DatabaseConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class MotorhomeApplication {

    public static void main(String[] args) {

        SpringApplication.run(MotorhomeApplication.class, args);

    }
}
