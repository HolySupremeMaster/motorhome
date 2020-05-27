package com.example.motorhomenordic.models;

public class Employee {
  private String firstName;
  private String lastName;
  private double salary;
  private int managerID;

    public Employee(String firstName, String lastName, double salary, int managerID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerID = managerID;
    }

    public Employee() {
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }

    public int getManagerID() { return managerID; }

    public void setManagerID(int managerID) { this.managerID = managerID; }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", managerID=" + managerID +
                '}';
    }
}
