package com.example.mallproject.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zzzk1
 */
@Data
public class UserDTO implements Serializable {
    private String username;
    private String password;
    private String email;
    private String role;
}
