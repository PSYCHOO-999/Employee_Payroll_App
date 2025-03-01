package com.bridgelabz.EmployeePayRollapp.service;
import com.bridgelabz.EmployeePayRollapp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayRollapp.entity.Employee;
import com.bridgelabz.EmployeePayRollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());

        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeDTO(savedEmployee.getName(), savedEmployee.getSalary());
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()))
                .collect(Collectors.toList());
    }
}

