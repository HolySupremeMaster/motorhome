package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.Dropoff;
import com.example.motorhomenordic.models.MotorHome;
import com.example.motorhomenordic.models.Pickup;

public interface IDropoffRepository {

    public void createDropoff(Dropoff dropoff);

    public Dropoff getDropoff(int booking_id);

    public boolean updateDropoff(Dropoff dropoff);

    public boolean deleteDropoff(int booking_id);

}
