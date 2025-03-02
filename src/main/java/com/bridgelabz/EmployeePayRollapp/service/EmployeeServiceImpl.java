package com.bridgelabz.EmployeePayRollapp.service;

import com.bridgelabz.EmployeePayRollapp.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import com.bridgelabz.EmployeePayRollapp.entity.Employee;
import com.bridgelabz.EmployeePayRollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j  // Enables Logging
@Service  // Marks this as a Service Layer
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired  // Injects EmployeeRepository
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from database");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Employee not found with ID: " + id));
    }

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        log.info("Adding new Employee: {}", employeeDTO.getName());
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        log.info("Updating Employee with ID: {}", id);
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        log.warn("Deleting Employee with ID: {}", id);
        employeeRepository.deleteById(id);
    }
}



