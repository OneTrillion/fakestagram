package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.UserDAO;
import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.model.UserInfo;
import com.grupp3.fakestagram.security.AuthenticationFacade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Service
public class UserService implements UserDetailsService {
    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;
    private AuthenticationFacade authenticationFacade;

    public void registerNewUser(User user){
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        userDAO.saveUserState(user);
    }

    public void changePassword(String newPassword){
        User currentUser = getCurrentUser();
        passwordEncoder.encode(newPassword);
        userDAO.changeUserPassword(currentUser, newPassword);
    }

    public void changeProfilePicture(String newProfilePicturePath){
        User currentUser = getCurrentUser();
        userDAO.changeProfilePicture(currentUser, newProfilePicturePath);
    }

    public void changeBio(String newBio){
        User currentUser = getCurrentUser();
        userDAO.changeBio(currentUser, newBio);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getCurrentUser() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return findUserByUsername(authentication.getName());
    }

    public User findUserByUsername(String username) {
        return userDAO
                .selectUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
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
        User allUserDetails = userDAO.selectUserByUsername(username)
                        .orElseThrow(() ->
                                new UsernameNotFoundException(String.format("Username %s not found", username))
                        );

        return  setRelevantUserInfo(allUserDetails);
    }

    public UserInfo getRelevantUserInfo() {
        User currentUser = getCurrentUser();

        return setRelevantUserInfo(currentUser);
    }

    private UserInfo setRelevantUserInfo(User user) {
        UserInfo userInfo = new UserInfo();

        userInfo.setName(user.getName());
        userInfo.setAge(user.getAge());
        userInfo.setBio(user.getBio());
        userInfo.setProfilePicturePath(user.getProfilePicturePath());
        userInfo.setUsername(user.getUsername());
        userInfo.setFollowerIds(user.getFollowerIds());
        userInfo.setFollowingIds(user.getFollowingIds());

        return userInfo;
    }

    private void checkIfUserIsSame(String username) {
        String currentUsername = getCurrentUser().getName();
        if (currentUsername.equalsIgnoreCase(username)) {
            throw new IllegalStateException("Input username can not be same as logged in user");
        }
    }

    public void followUser(String username) {
        User currentUser = getCurrentUser();
        Long userToFollow = findUserByUsername(username).getId();
        checkIfUserIsSame(username);
        currentUser.getFollowingIds().add(userToFollow);

        userDAO.saveUserState(currentUser);
    }

    public void unfollowUser(String username) {
        User currentUser = getCurrentUser();
        Long userToFollow = findUserByUsername(username).getId();
        checkIfUserIsSame(username);
        currentUser.getFollowingIds().remove(userToFollow);

        userDAO.saveUserState(currentUser);

    }

}
