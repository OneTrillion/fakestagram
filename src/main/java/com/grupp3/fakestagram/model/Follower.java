package com.grupp3.fakestagram.model;

public class Follower {
    private Long id;
    private Long userId;
    private Long eachFollowerId;

    public Follower(Long id, Long userId, Long eachFollowerId) {
        this.id = id;
        this.userId = userId;
        this.eachFollowerId = eachFollowerId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getEachFollowerId() {
        return eachFollowerId;
    }
}
