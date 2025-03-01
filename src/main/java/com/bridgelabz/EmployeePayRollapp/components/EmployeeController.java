package com.bridgelabz.EmployeePayRollapp.components;
import org.springframework.web.bind.annotation.*;
import com.bridgelabz.EmployeePayRollapp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayRollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
