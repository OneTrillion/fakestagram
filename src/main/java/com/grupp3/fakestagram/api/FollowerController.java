package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.Follower;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/follower")
public class FollowerController {
    @GetMapping("/followertest")
    public Follower viewFollowers(){
        Follower testFollower = new Follower(242352L,23652352L);
        return testFollower;
    }
}
