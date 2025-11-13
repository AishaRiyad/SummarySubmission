package com.example.demo3;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        roleRepository.findByName("ROLE_USER").orElseGet(() -> roleRepository.save(newRole("ROLE_USER")));
        roleRepository.findByName("ROLE_ADMIN").orElseGet(() -> roleRepository.save(newRole("ROLE_ADMIN")));
    }

    private Role newRole(String name) {
        Role r = new Role();
        r.setName(name);
        return r;
    }
}
