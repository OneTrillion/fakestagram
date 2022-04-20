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

    @GetMapping("/all")
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/follow/{username}")
    public void followUser(@PathVariable String username) {
        userService.followUser(username);
    }

    @DeleteMapping("/unfollow{username}")
    public void unfollowUser(@PathVariable String username) {
        userService.unfollowUser(username);
    }

    @PostMapping("/register-user")
    public void registerNewUser(@RequestBody User user){
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

    @GetMapping("/find-user-by/{id}")
    public UserInfo getInfoByUserId(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/current-user")
    public UserInfo getRelevantUserInfo() {
        return userService.getRelevantUserInfo();
    }
/*
//TODO kanske ta bort?

    @GetMapping("/current-user")
    public String currentUsername(Authentication authentication) {
        return authentication.getName();
    }

 */

}
