package com.grupp3.fakestagram.api;


import com.grupp3.fakestagram.model.Following;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/following")
public class FollowingsController {
    @GetMapping("/followingtest")
    public Following viewFollowing(){
        Following testFollowing = new Following(2523525L,35252L);
        return testFollowing;
    }
}