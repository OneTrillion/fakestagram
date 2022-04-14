package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.UserDAO;
import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.model.UserInfo;
import com.grupp3.fakestagram.repository.UserRepository;
import com.grupp3.fakestagram.security.AuthenticationFacade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
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
    private AuthenticationFacade authenticationFacade;


    //follow unfollow

    public void registerNewUser(User user){
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        userDAO.registerNewUser(user);
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

    //TODO fixa så att den har followersIds
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
        //userInfo.setPostIds(allUserDetails.getPostsIds());
        userInfo.setBio(allUserDetails.getBio());
        userInfo.setProfilePicturePath(allUserDetails.getProfilePicturePath());
        userInfo.setUsername(allUserDetails.getUsername());

        return userInfo;
    }

    private void checkIfUserIsSame(String username) {
        String currentUsername = getCurrentUser().getName();
        if (currentUsername.equalsIgnoreCase(username)) {
            throw new IllegalStateException("Input username can not be same as logged in user");
        }
    }

    //TODO: code duplication i follow och unfollow, fixa detta
    public void followUser(String username) {
        User currentUser = getCurrentUser();
        Long userToFollow = findUserByUsername(username).getId();
        checkIfUserIsSame(username);
        currentUser.getFollowingIds().add(userToFollow);

        userDAO.followUser(currentUser);
    }

    //TODO ditto ^^^
    public void unfollowUser(String username) {
        User currentUser = getCurrentUser();
        Long userToFollow = findUserByUsername(username).getId();
        checkIfUserIsSame(username);
        currentUser.getFollowingIds().remove(userToFollow);

        userDAO.unfollowUser(currentUser);

    }

}
