package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.model.UserInfo;
import com.grupp3.fakestagram.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private UserService userService;

    @GetMapping("/usertest")
    public User viewUser(){
        Set<GrantedAuthority> grantedAuth = new HashSet<>();
        User testUser = new User("Love",22,7356,2,13,"Live life.", "asdasd","LoveIsLife","password123", grantedAuth, true, true, true, true);
        return testUser;
    }

    //TODO delete in final version?
    @GetMapping("/all")
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register-user")
    public void registerNewUser(@Valid @RequestBody User user){
        userService.registerNewUser(user);
    }

    @PutMapping("/change-password")
    public void changeUserPassword(@NotBlank @RequestBody String newPassword){
        userService.changePassword(newPassword);
    }

    @PutMapping("/change-profile-picture")
    public void changeProfilePicturePath(@NotBlank @RequestBody String newProfilePicturePath){
        userService.changeProfilePicture(newProfilePicturePath);
    }

    @PutMapping("/change-bio")
    public void changeBio(@RequestBody String newBio){
        userService.changeBio(newBio);
    }

    @GetMapping("/user-info/{username}")
    public UserInfo getRelevantUserInfoByUsername(@PathVariable String username) {
        return userService.getRelevantUserInfoByUsername(username);
    }
//TODO kanske ta bort?
    @GetMapping("/current-user")
    public String currentUsername(Authentication authentication) {
        return authentication.getName();
    }
//TODO kanske ta bort
    @GetMapping("/cu")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
