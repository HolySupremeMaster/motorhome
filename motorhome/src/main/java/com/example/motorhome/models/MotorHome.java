package com.example.motorhome.models;

public class MotorHome {
    private int motorhome_id;
    private String brand;
    private String model;
    private double price;
    private String type;
    private int persons;

    public MotorHome() {
    }

    public MotorHome(int motorhome_id, String brand, String model, int price, String type, int persons) {
        this.motorhome_id = motorhome_id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.type = type;
        this.persons = persons;
    }

    public int getMotorhome_id() { return motorhome_id; }

    public void setMotorhome_id(int motorhome_id) { this.motorhome_id = motorhome_id; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public int getPersons() { return persons; }

    public void setPersons(int persons) { this.persons = persons; }

    @Override
    public String toString() {
        return "MotorHome{" +
                "motorhome_id=" + motorhome_id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", persons=" + persons +
                '}';
    }
}
