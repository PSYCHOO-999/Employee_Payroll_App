package com.bridgelabz.EmployeePayRollapp.dto;

import lombok.*;

@Data // Generates Getters, Setters, equals(), hashCode(), toString()
@NoArgsConstructor // Generates Default Constructor
@AllArgsConstructor // Generates Constructor with All Fields
public class EmployeeDTO {
    private Long id;
    private String name;
    private double salary;
}


