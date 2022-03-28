package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class UserService {
    private UserRepository userRepository;

    public void registerNewUser(){
        System.out.println("wooo");
        User Kevin = new User("Kevin", 31, 149, 150, 14, "Live, love, laugh", "kevincoolpisol", "kanelbullar74");
        //userRepository.save(Kevin);
    }

    public void changePassword(){

    }

    public void changeProfilePicture(){

    }

    public void editProfileDescription(){

    }

}
