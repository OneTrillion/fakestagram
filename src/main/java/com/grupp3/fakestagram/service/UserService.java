package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.UserDAO;
import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Service
public class UserService {
    private UserDAO userDAO;
    UserRepository userRepository;

    public void registerNewUser(User user){
        userDAO.registerNewUser(user);
    }

    public void changePassword(User user, String newPassword){
        userDAO.changeUserPassword(user, newPassword);
    }

    public void changeProfilePicture(User user, String newProfilePicturePath){
        userDAO.changeProfilePicture(user, newProfilePicturePath);
    }

    public void changeBio(User user, String newBio){
        userDAO.changeBio(user, newBio);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
