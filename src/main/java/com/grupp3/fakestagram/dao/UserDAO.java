package com.grupp3.fakestagram.dao;

import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Repository
public class UserDAO {
    private UserRepository userRepository;

    public void registerNewUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void changeUserPassword(User user, String newPassword){
        userRepository.setNewPasswordByUserId(newPassword, user.getId());
    }

    public void changeProfilePicture(User user, String newProfilePicturePath){
        userRepository.setNewProfilePicturePathByUserId(newProfilePicturePath, user.getId());
    }

    public void changeBio(User user, String newBio){
        userRepository.setNewBioByUserId(newBio, user.getId());
    }

}