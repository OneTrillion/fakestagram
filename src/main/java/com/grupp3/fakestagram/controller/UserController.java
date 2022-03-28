package com.grupp3.fakestagram.controller;

import com.grupp3.fakestagram.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("/usertest")
    public User viewUser(){
        User testUser = new User(3523L,"Love",22,7356,2,13,"Live life.","LoveIsLife","password123");
        return testUser;

    }


}
