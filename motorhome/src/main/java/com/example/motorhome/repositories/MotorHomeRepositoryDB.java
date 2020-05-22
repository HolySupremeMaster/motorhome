package com.example.motorhome.repositories;

import com.example.motorhome.models.Booking;
import com.example.motorhome.models.MotorHome;
import sun.security.krb5.internal.crypto.RsaMd5CksumType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotorHomeRepositoryDB implements IMotorHomeRepository {

    private Connection conn;

    public MotorHomeRepositoryDB(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void createMotorhome(MotorHome motorhome) {
        try {
            PreparedStatement stmnt = conn.prepareStatement("INSERT INTO motorhome values (?,?,?,?,?,?)");
            stmnt.setInt(1,motorhome.getMotorhome_id());
            stmnt.setString(2,motorhome.getBrand());
            stmnt.setString(3,motorhome.getModel());
            stmnt.setDouble(4,motorhome.getPrice());
            stmnt.setString(5,motorhome.getType());
            stmnt.setInt(6,motorhome.getPersons());
            stmnt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public MotorHome getMotorhome(int motorhome_id) {
       MotorHome motorhome = new MotorHome();

       try {
           PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM motorhome where motorhome_id=?");
            stmnt.setInt(1,motorhome_id);
           ResultSet rs = stmnt.executeQuery();

           while (rs.next()){
               motorhome.setMotorhome_id(rs.getInt(1));
               motorhome.setBrand(rs.getString(2));
               motorhome.setModel(rs.getString(3));
               motorhome.setPrice(rs.getDouble(4));
               motorhome.setType(rs.getString(5));
               motorhome.setPersons(rs.getInt(6));

           }
       } catch (Exception e) {
           e.printStackTrace();
       }

        return motorhome;
    }

    @Override
    public List<MotorHome> getAllMotorhome() {
        List <MotorHome> motorHomeList = new ArrayList<>();

        try {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM motorhome");

                while (rs.next()){
                    MotorHome motorhome = new MotorHome();
                    motorhome.setMotorhome_id(rs.getInt(1));
                    motorhome.setBrand(rs.getString(2));
                    motorhome.setModel(rs.getString(3));
                    motorhome.setPrice(rs.getDouble(4));
                    motorhome.setType(rs.getString(5));
                    motorhome.setPersons(rs.getInt(6));

                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motorHomeList;
    }

    @Override
    public boolean updateMotorhome(MotorHome motormome) {
        try {
            PreparedStatement stmnt = conn.prepareStatement("UPDATE motorhome SET motorhome_id=?, brand=?, model=?, price=?, type=?, persona=?");

            stmnt.setInt(1,motormome.getMotorhome_id());
            stmnt.setString(2,motormome.getBrand());
            stmnt.setString(3,motormome.getModel());
            stmnt.setDouble(4,motormome.getPrice());
            stmnt.setString(5,motormome.getType());
            stmnt.setInt(6,motormome.getPersons());
            stmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMotorhome(int motorhome_id) {
        PreparedStatement stmnt = null;
        try {
            stmnt =conn.prepareStatement("DELETE from motorhome where motorhome=?");
            stmnt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
