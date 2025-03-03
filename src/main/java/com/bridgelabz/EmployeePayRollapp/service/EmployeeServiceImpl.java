package com.bridgelabz.EmployeePayRollapp.service;

import com.bridgelabz.EmployeePayRollapp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayRollapp.entity.Employee;
import com.bridgelabz.EmployeePayRollapp.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee addEmployee(@Valid EmployeeDTO employeeDTO) {
        log.info("Adding new employee: {}", employeeDTO.getName());
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, @Valid EmployeeDTO employeeDTO) {
        Employee existingEmployee = getEmployeeById(id);
        log.info("Updating employee with ID: {}", id);
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        log.info("Deleted employee with ID: {}", id);
    }
}
