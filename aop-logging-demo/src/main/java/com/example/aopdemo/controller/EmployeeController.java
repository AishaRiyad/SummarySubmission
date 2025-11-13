package com.example.aopdemo.controller;


import com.example.aopdemo.model.Employee;
import com.example.aopdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service){ this.service = service; }

    @GetMapping
    public List<Employee> all(){ return service.findAll(); }

    @PostMapping
    public Employee create(@RequestBody Employee e){ return service.create(e); }


}
