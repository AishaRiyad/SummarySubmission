package com.example.testing_demo.controller;


import com.example.testing_demo.model.Employee;
import com.example.testing_demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee e) {
        return service.saveEmployee(e);
    }

    @GetMapping
    public List<Employee> all() {
        return service.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> byId(@PathVariable long id) {
        return service.getEmployeeById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> update(@PathVariable long id, @RequestBody Employee e) {
        return service.getEmployeeById(id).map(saved -> {
            saved.setFirstName(e.getFirstName());
            saved.setLastName(e.getLastName());
            saved.setEmail(e.getEmail());
            return ResponseEntity.ok(service.updateEmployee(saved));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }
}
