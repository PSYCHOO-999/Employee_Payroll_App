package com.bridgelabz.EmployeePayRollapp.service;
import com.bridgelabz.EmployeePayRollapp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayRollapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
}


