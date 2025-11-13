package com.example.testing_demo.service;


import com.example.testing_demo.model.Employee;
import com.example.testing_demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        repo.findByEmail(employee.getEmail()).ifPresent(e -> {
            throw new IllegalStateException("Employee already exist with email: " + employee.getEmail());
        });
        return repo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return repo.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee updatedEmployee) {
        return repo.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(long id) {
        repo.deleteById(id);
    }
}
