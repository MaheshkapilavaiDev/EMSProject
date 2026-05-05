package com.employyemanagementsystem.service;



import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employyemanagementsystem.entity.Employee;
import com.employyemanagementsystem.repository.EmployeeRepository;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    public Employee create(Employee emp) {
        log.info("Creating employee: {}", emp.getName());
        return repo.save(emp);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    
    public long getTotalEmployees() {
        return repo.count();
    }

    public double getAverageSalary() {
        return repo.findAll().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    public Map<String, Long> getDepartmentCount() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    public Employee update(Long id, Employee emp) {
        Employee existing = getById(id);
        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setDepartment(emp.getDepartment());
        existing.setSalary(emp.getSalary());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
