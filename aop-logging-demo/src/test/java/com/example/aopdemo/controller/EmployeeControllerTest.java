package com.example.aopdemo.controller;

import com.example.aopdemo.model.Employee;
import com.example.aopdemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.BDDMockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private EmployeeService employeeService;

    private Employee aisha;

    @BeforeEach
    void setup() {
        aisha = new Employee("Aisha", "Riyad", "aisha@example.com");
        aisha.setId(1L);
    }

    @Test
    void givenEmployees_whenGetAll_thenStatusOkAndJsonArray() throws Exception {

        given(employeeService.findAll()).willReturn(List.of(aisha));

        mvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("Aisha"))
                .andExpect(jsonPath("$[0].lastName").value("Riyad"))
                .andExpect(jsonPath("$[0].email").value("aisha@example.com"));
    }

    @Test
    void whenCreateEmployee_thenReturnCreatedEmployee() throws Exception {

        Employee requestBody = new Employee("Amal", "Aldeek", "amal@example.com");
        Employee saved = new Employee("Amal", "Aldeek", "amal@example.com");
        saved.setId(2L);

        given(employeeService.create(any(Employee.class))).willReturn(saved);

        mvc.perform(
                        post("/api/v1/employees")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestBody))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.firstName").value("Amal"))
                .andExpect(jsonPath("$.lastName").value("Aldeek"))
                .andExpect(jsonPath("$.email").value("amal@example.com"));
    }

}

