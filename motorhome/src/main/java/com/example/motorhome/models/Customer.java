package com.example.motorhome.models;

public class Customer {
    private String firstName;
    private String lastName;
    private int driverLicense;
    private String email;
    private int phoneNumber;
    private int customerID;
    private int age;
    private String address;

    public Customer(String firstName, String lastName, int driverLicense, String email, int phoneNumber, int customerID, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.driverLicense = driverLicense;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.customerID = customerID;
        this.age = age;
        this.address = address;
    }

    public Customer() {
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getDriverLicense() { return driverLicense; }

    public void setDriverLicense(int driverLicense) { this.driverLicense = driverLicense; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getCustomerID() { return customerID; }

    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", driverLicense=" + driverLicense +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", customerID=" + customerID +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}