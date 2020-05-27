package com.example.motorhomenordic.repositories;

import com.example.motorhomenordic.models.MotorHome;

import java.util.List;

public interface IMotorHomeRepository {

    public void createMotorhome(MotorHome motorhome);

    public MotorHome getMotorhome(int motorhome);

    public List<MotorHome> getAllMotorhome();

    public boolean updateMotorhome (MotorHome motorhome);

    public boolean deleteMotorhome (int motorhome_id);
}
