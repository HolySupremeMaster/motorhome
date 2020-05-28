package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.MotorHome;
import com.example.motorhomenordic.models.Pickup;

import java.util.List;

public interface IPickupRepository {


    public void createPickup(Pickup pickup);

    public Pickup getPickup(int booking_id);

    public boolean updatePickup (Pickup pickup);

    public boolean deletePickup (int booking_id);

}
