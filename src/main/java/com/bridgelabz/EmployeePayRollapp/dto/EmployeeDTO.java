package com.bridgelabz.EmployeePayRollapp.dto;

import lombok.*;

@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    private String name;
    private double salary;

    // Default Constructor
    public EmployeeDTO() {}

    // Parameterized Constructor
    public EmployeeDTO(Long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getter and Setter for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) { // No error now!
        this.id = id;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for Salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
