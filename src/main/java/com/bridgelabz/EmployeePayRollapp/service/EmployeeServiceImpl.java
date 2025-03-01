package com.bridgelabz.EmployeePayRollapp.service;

import com.bridgelabz.EmployeePayRollapp.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<EmployeeDTO> employeeList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1); // Auto-increment ID

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeList;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setId(counter.getAndIncrement()); // Assign an ID
        employeeList.add(employeeDTO);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        for (EmployeeDTO emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(employeeDTO.getName());
                emp.setSalary(employeeDTO.getSalary());
                return emp;
            }
        }
        return null; // In real cases, throw an exception
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}


