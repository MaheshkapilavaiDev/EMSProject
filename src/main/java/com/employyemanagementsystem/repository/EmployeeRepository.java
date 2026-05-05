package com.employyemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employyemanagementsystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
