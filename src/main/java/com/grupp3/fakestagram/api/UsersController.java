package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private UserService userService;


    @GetMapping("/usertest")
    public User viewUser(){
        User testUser = new User("Love",22,7356,2,13,"Live life.", "asdasd","LoveIsLife","password123");
        return testUser;
    }

    @GetMapping("/all")
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register-user")
    public void registerNewUser(@Valid @RequestBody User user){
        userService.registerNewUser(user);
    }

    @PutMapping("/change-password")
    public void changeUserPassword(@Valid @RequestBody User user,
                                   @NotBlank @RequestBody String newPassword){
        userService.changePassword(user, newPassword);
    }

    @PutMapping("/change-profile-picture")
    public void changeProfilePicturePath(@Valid @RequestBody User user,
                                         @NotBlank @RequestBody String newProfilePicturePath){
        userService.changeProfilePicture(user, newProfilePicturePath);
    }

    @PutMapping("/change-bio")
    public void changeBio(@Valid @RequestBody User user,
                          @NotBlank @RequestBody String newBio){
        userService.changeBio(user, newBio);
    }


}
