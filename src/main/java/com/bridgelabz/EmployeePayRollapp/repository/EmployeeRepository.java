package com.bridgelabz.EmployeePayRollapp.repository;

import com.bridgelabz.EmployeePayRollapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
