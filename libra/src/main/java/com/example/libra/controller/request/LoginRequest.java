package com.example.libra.controller.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String librarynumber;
    private String password;
}
