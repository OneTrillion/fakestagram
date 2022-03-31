package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;


    @GetMapping("/usertest")
    public User viewUser(){
        User testUser = new User("Love",22,7356,2,13,"Live life.","LoveIsLife","password123");
        return testUser;
    }

    @PostMapping("/register-user")
    public void registerNewUser(){
        userService.registerNewUser();
    }


}
