package com.employyemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.employyemanagementsystem.entity.Employee;
import com.employyemanagementsystem.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee create(@Valid @RequestBody Employee emp) {
		return service.create(emp);
	}

	@GetMapping("/getAll")
	 @PreAuthorize("hasAnyRole('ADMIN','USER')")
	public List<Employee> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
		return service.update(id, emp);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "Employee deleted successfully";
	}
}
