package com.bridgelabz.EmployeePayRollapp.components;
import org.springframework.web.bind.annotation.*;
import com.bridgelabz.EmployeePayRollapp.service.EmployeeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.bridgelabz.EmployeePayRollapp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayRollapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        log.info("Fetching all employees via GET /employees");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Fetching Employee with ID: {}", id);
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.info("POST /employees - Adding Employee: {}", employeeDTO.getName());
        return employeeService.addEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        log.info("PUT /employees/{} - Updating Employee", id);
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        log.info("DELETE /employees/{} - Deleting Employee", id);
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully!";
    }
}


