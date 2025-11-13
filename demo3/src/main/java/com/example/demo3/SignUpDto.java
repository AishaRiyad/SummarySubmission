package com.example.demo3;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class SignUpDto {
    @NotBlank private String name;
    @NotBlank @Size(min = 3, max = 50) private String username;
    @NotBlank @Email private String email;
    @NotBlank @Size(min = 8) private String password;
}
