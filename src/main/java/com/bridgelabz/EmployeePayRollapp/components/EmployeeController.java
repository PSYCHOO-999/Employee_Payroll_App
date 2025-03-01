package com.bridgelabz.EmployeePayRollapp.components;
import com.bridgelabz.EmployeePayRollapp.entity.Employee;
import com.bridgelabz.EmployeePayRollapp.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // 1️⃣ GET: Fetch all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 2️⃣ GET: Fetch employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // 3️⃣ POST: Create a new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // 4️⃣ PUT: Update an existing employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    // 5️⃣ DELETE: Delete an employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Employee with ID " + id + " deleted successfully";
    }
}
