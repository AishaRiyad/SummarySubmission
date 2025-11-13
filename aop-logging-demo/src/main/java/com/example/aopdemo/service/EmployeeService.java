package com.example.aopdemo.service;


import com.example.aopdemo.model.Employee;
import com.example.aopdemo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo){ this.repo = repo; }

    public List<Employee> findAll(){ return repo.findAll(); }
    public Employee create(Employee e){ return repo.save(e); }
}
