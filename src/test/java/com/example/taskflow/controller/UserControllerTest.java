package com.example.taskflow.controller;

import com.example.taskflow.model.entity.User;
import com.example.taskflow.security.JwtUtil;
import com.example.taskflow.service.interfaces.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private UserService userService;


    @MockitoBean
    private JwtUtil jwtUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void givenUsers_whenGetAll_thenReturnJsonArray() throws Exception {
        User u1 = User.builder()
                .id(1L)
                .username("aisha")
                .email("aisha@example.com")
                .password("pass")
                .roles(Set.of("ROLE_USER"))
                .build();

        given(userService.getAllUsers()).willReturn(List.of(u1));

        mvc.perform(get("/api/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username", is("aisha")));
    }

    @Test
    void givenUser_whenCreate_thenReturnCreated() throws Exception {
        User req = User.builder()
                .username("amal")
                .email("amal@example.com")
                .password("12345678")
                .roles(Set.of("ROLE_USER"))
                .build();

        User saved = User.builder()
                .id(2L)
                .username("amal")
                .email("amal@example.com")
                .password("encoded")
                .roles(Set.of("ROLE_USER"))
                .build();

        given(userService.createUser(any(User.class))).willReturn(saved);

        mvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.username", is("amal")));
    }
}
