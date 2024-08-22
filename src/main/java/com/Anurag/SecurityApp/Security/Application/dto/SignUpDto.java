package com.Anurag.SecurityApp.Security.Application.dto;

import lombok.Data;

@Data
public class SignUpDto {

    private Long id;
    private String email;
    private String password;
    private String name;

}
