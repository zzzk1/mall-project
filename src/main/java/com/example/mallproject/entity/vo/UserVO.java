package com.example.mallproject.entity.vo;

import com.example.mallproject.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class UserVO {
    private String username;
    private String nickname;
    private String email;
    private String avatarUrl;
    private String token;
    private List<Menu> menus;
    private String role;
}
