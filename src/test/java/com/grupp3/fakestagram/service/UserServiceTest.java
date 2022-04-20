package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.UserDAO;
import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.repository.UserRepository;
import com.grupp3.fakestagram.security.AuthenticationFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDAO userDAO;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AuthenticationFacade authenticationFacade;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userDAO, passwordEncoder, authenticationFacade);
    }

    @Test
    void registerNewUser() {

    }

    @Test
    void changePassword() {
    }

    @Test
    void changeProfilePicture() {
    }

    @Test
    void changeBio() {
    }

    @Test
    void getAllUsers() {
        //when
        underTest.getAllUsers();

        //then
        Mockito.verify(userDAO).getAllUsers();
    }

    @Test
    @Disabled
    void getCurrentUser() {
        //when
        underTest.getCurrentUser();

        //SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        authentication.setAuthenticated(true);
        //Mockito.when(authentication.getPrincipal()).thenReturn(new User())

        Mockito.when(authenticationFacade.getAuthentication()).thenReturn(authentication);
        Mockito.when(authentication.getName()).thenReturn("testname");
        Mockito.when(underTest.findUserByUsername(authentication.getName())).thenReturn(new User(
                "testname",
                12,
                0,
                "testBio",
                "testPath",
                List.of(5L),
                List.of(5L),
                "username",
                "password",
                null,
                true,
                true,
                true,
                true
        ));
        //SecurityContextHolder.setContext(securityContext);
        //then
        Mockito.verify(authenticationFacade.getAuthentication()).getName();
    }

    @Test
    void findUserByUsername() {
        //given
        String username = "testUsername";
        User user = new User(
                "testname",
                12,
                0,
                "testBio",
                "testPath",
                List.of(5L),
                List.of(5L),
                "username",
                "password",
                null,
                true,
                true,
                true,
                true
        );
        //when
        Mockito.when(userDAO.selectUserByUsername(username)).thenReturn(Optional.of(user));
        underTest.findUserByUsername(username);
        //then
        Mockito.verify(userDAO).selectUserByUsername(username);
    }

    @Test
    void loadUserByUsername() {
    }

    @Test
    void getRelevantUserInfoByUsername() {
    }

    @Test
    @WithMockUser
    void getRelevantUserInfo() {

    }

    @Test
    void followUser() {
    }

    @Test
    void unfollowUser() {
    }

    @Test
    void getUserDAO() {
    }

    @Test
    void getPasswordEncoder() {
    }

    @Test
    void getAuthenticationFacade() {
    }

    @Test
    void setUserDAO() {
    }

    @Test
    void setPasswordEncoder() {
    }

    @Test
    void setAuthenticationFacade() {
    }
}