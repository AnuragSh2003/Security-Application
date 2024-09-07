package com.Anurag.SecurityApp.Security.Application.dto;

import com.Anurag.SecurityApp.Security.Application.entities.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDto {

    private Long id;
    private String email;
    private String password;
    private String name;
    private Set<Role> roles;

}
