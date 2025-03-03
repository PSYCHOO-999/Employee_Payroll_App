package com.bridgelabz.EmployeePayRollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Name should start with a capital letter and have at least 3 characters")
    private String name;

    private double salary;  // Assuming salary is part of EmployeeDTO
}
