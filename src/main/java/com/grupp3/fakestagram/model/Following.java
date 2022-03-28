package com.grupp3.fakestagram.model;

public class Following {
    private Long id;
    private Long userId;
    private Long eachFollowingId;

    public Following(Long id, Long userId, Long eachFollowingId) {
        this.id = id;
        this.userId = userId;
        this.eachFollowingId = eachFollowingId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getEachFollowingId() {
        return eachFollowingId;
    }
}
