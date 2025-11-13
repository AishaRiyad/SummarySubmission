package com.example.testing_demo.controller;


import com.example.testing_demo.model.Employee;
import com.example.testing_demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager em;
    @Autowired private EmployeeRepository repo;

    @Test
    void findByEmail_returnsEmployee() {
        var e = new Employee("Aisha","Riyad","aisha@example.com");
        em.persistAndFlush(e);

        var found = repo.findByEmail("aisha@example.com");
        assertThat(found).isPresent();
        assertThat(found.get().getFirstName()).isEqualTo("Aisha");
    }
}
