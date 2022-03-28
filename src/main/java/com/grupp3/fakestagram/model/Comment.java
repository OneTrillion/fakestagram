package com.grupp3.fakestagram.model;

import java.util.UUID;


public class Comment {
    private Long id;
    private String comment;
    private UUID userId;
    private UUID postId;
    private int likes;


    public Comment(Long id,String comment, UUID userId, UUID postId, int likes) {
        this.id = id;
        this.comment = comment;
        this.userId = userId;
        this.postId = postId;
        this.likes = likes;
    }

    public String getComment() {
        return comment;
    }

    public Long getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getPostId() {
        return postId;
    }

    public int getLikes() {
        return likes;
    }
}
