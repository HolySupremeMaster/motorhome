package com.example.motorhome.repositories;

import com.example.motorhome.models.MotorHome;

public interface IMotorHomeRepository {
    public void createMotorhome(MotorHome motorhome);

    public MotorHome getMotorhome(MotorHome motorhome);
}
