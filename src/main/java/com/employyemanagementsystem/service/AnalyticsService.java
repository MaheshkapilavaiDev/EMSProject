package com.employyemanagementsystem.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employyemanagementsystem.entity.Employee;
import com.employyemanagementsystem.repository.EmployeeRepository;

@Service
public class AnalyticsService {

	@Autowired
	private EmployeeRepository repository;

	public Map<String, Object> getDashboardData() {

		Map<String, Object> response = new HashMap<>();

		long totalEmployees = repository.count();

		Map<String, Long> deptCount = repository.findAll().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		response.put("totalEmployees", totalEmployees);
		response.put("employeesByDepartment", deptCount);

		return response;
	}

}
