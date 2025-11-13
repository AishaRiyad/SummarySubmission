package com.example.testing_demo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIT {
    @Autowired
    private MockMvc mvc;

    @Test
    void getAll_returns200() throws Exception {
        mvc.perform(get("/api/employees"))
                .andExpect(status().isOk());
    }

}
