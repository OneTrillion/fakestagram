package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.UserDAO;
import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.model.UserInfo;
import com.grupp3.fakestagram.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
@Service
public class UserService implements UserDetailsService {
    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    public void registerNewUser(User user){
        String password = user.getPassword();
        passwordEncoder.encode(password);
        user.setPassword(password);
        userDAO.registerNewUser(user);
    }

    public void changePassword(User user, String newPassword){
        passwordEncoder.encode(newPassword);
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

    public UserInfo getRelevantUserInfoByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        User allUserDetails = userDAO.selectUserByUsername(username)
                        .orElseThrow(() ->
                                new UsernameNotFoundException(String.format("Username %s not found", username))
                        );

        userInfo.setName(allUserDetails.getName());
        userInfo.setAge(allUserDetails.getAge());
        userInfo.setFollowers(allUserDetails.getFollowers());
        userInfo.setFollowing(allUserDetails.getFollowing());
        userInfo.setPosts(allUserDetails.getPosts());
        userInfo.setBio(allUserDetails.getBio());
        userInfo.setProfilePicturePath(allUserDetails.getProfilePicturePath());
        userInfo.setUsername(allUserDetails.getUsername());

        return userInfo;
    }
}
