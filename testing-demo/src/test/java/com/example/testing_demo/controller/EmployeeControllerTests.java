package com.example.testing_demo.controller;

import com.example.testing_demo.model.Employee;
import com.example.testing_demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @org.springframework.test.context.bean.override.mockito.MockitoBean
    private EmployeeService employeeService;

    @Test
    void create_returns201_andBody() throws Exception {
        var req = new Employee("Ramesh", "Fadatare", "r@gmail.com");
        var saved = new Employee("Ramesh", "Fadatare", "r@gmail.com");
        saved.setId(1L);
        given(employeeService.saveEmployee(any(Employee.class))).willReturn(saved);

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName", is("Ramesh")));
    }

    @Test
    void getAll_returns200_andList() throws Exception {
        var e1 = new Employee("Aisha", "Riyad", "a@example.com");
        e1.setId(1L);
        var e2 = new Employee("Amal", "Aldeek", "amal@example.com");
        e2.setId(2L);
        given(employeeService.getAllEmployees()).willReturn(List.of(e1, e2));

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }

    @Test
    void getById_found_returns200() throws Exception {
        var e = new Employee("Aisha", "Riyad", "a@example.com");
        e.setId(7L);
        given(employeeService.getEmployeeById(7L)).willReturn(Optional.of(e));

        mockMvc.perform(get("/api/employees/{id}", 7))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(7))
                .andExpect(jsonPath("$.email", is("a@example.com")));
    }

    @Test
    void getById_notFound_returns404() throws Exception {
        given(employeeService.getEmployeeById(999L)).willReturn(Optional.empty());

        mockMvc.perform(get("/api/employees/{id}", 999))
                .andExpect(status().isNotFound());
    }

    @Test
    void update_found_returns200() throws Exception {
        long id = 5L;
        var saved = new Employee("X", "Y", "old@example.com");
        saved.setId(id);
        var update = new Employee("Amal", "Aldeek", "amal@example.com");
        given(employeeService.getEmployeeById(id)).willReturn(Optional.of(saved));
        given(employeeService.updateEmployee(any(Employee.class)))
                .willAnswer(inv -> inv.getArgument(0));

        mockMvc.perform(put("/api/employees/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Amal")))
                .andExpect(jsonPath("$.email", is("amal@example.com")));
    }

    @Test
    void update_notFound_returns404() throws Exception {
        long id = 123L;
        var update = new Employee("A", "B", "c@example.com");
        given(employeeService.getEmployeeById(id)).willReturn(Optional.empty());

        mockMvc.perform(put("/api/employees/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andExpect(status().isNotFound());
    }

    @Test
    void delete_returns200() throws Exception {
        long id = 1L;
        willDoNothing().given(employeeService).deleteEmployee(id);

        mockMvc.perform(delete("/api/employees/{id}", id))
                .andExpect(status().isOk());
    }

}
