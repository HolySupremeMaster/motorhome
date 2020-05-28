package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.Dropoff;
import com.example.motorhomenordic.models.MotorHome;
import com.example.motorhomenordic.models.Pickup;

public interface IDropoffRepository {

    public void createDropoff(Dropoff dropoff);

    public Dropoff getPickup(int booking_id);

    public boolean updatePickup (Dropoff dropoff);

    public boolean deletePickup (int booking_id);

}
