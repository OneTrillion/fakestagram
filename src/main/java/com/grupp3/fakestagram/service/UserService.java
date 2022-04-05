package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.UserDAO;
import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Service
public class UserService implements UserDetailsService {
    private UserDAO userDAO;

    public void registerNewUser(User user){
        userDAO.registerNewUser(user);
    }

    //TODO lägg till encode password
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO
                .selectUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );

    }
}
