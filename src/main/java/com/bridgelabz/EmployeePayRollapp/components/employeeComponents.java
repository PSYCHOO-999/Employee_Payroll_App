package com.bridgelabz.EmployeePayRollapp.components;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class employeeComponents {

    @GetMapping("/get")
    public String getEmplloyee(){
        return "Get Emploooyee called";
    }

    @GetMapping("/get/{empId}")
    public String getEmployeeByID(@PathVariable int empId){
        return "Get Employee Called By ID";
    }

    @PostMapping("/create")
    public String addEmployee(){
        return "Employee Added";
    }

    @PutMapping("/update")
    public String updateEmployee(){
        return "Employee Updated";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(){
        return "Employee Deleted";
    }

}
