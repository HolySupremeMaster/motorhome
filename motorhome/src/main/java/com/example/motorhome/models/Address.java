package com.example.motorhome.models;

public class Address {
    private int address_id;
    private String address;
    private int zip;
    private String city;

    public Address() {
    }

    public Address(int address_id, String address, int zip, String city) {
        this.address_id = address_id;
        this.address = address;
        this.zip = zip;
        this.city = city;
    }

    public int getAddress_id() { return address_id; }

    public void setAddress_id(int address_id) { this.address_id = address_id; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public int getZip() { return zip; }

    public void setZip(int zip) { this.zip = zip; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", address='" + address + '\'' +
                ", zip=" + zip +
                ", city='" + city + '\'' +
                '}';
    }
}
