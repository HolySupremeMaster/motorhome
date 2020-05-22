package com.example.motorhome.models;

public class Customer {
    private String firstName;
    private String lastName;
    private int driverLicense;
    private String email;
    private int phonenumber;
    private int customer_id;
    private int age;
    private String address_id;

    public Customer(String firstName, String lastName, int driverLicense, String email, int phoneNumber, int customerID, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.driverLicense = driverLicense;
        this.email = email;
        this.phonenumber = phoneNumber;
        this.customer_id = customerID;
        this.age = age;
        this.address_id = address;
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

    public int getPhonenumber() { return phonenumber; }

    public void setPhonenumber(int phonenumber) { this.phonenumber = phonenumber; }

    public int getCustomer_id() { return customer_id; }

    public void setCustomer_id(int customer_id) { this.customer_id = customer_id; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getAddress_id() { return address_id; }

    public void setAddress_id(String address_id) { this.address_id = address_id; }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", driverLicense=" + driverLicense +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phonenumber +
                ", customerID=" + customer_id +
                ", age=" + age +
                ", address='" + address_id + '\'' +
                '}';
    }
}