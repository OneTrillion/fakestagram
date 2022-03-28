package com.grupp3.fakestagram.model;

public class Post {
    private Long id;
    private String description;
    private int likes;
    private String date;

    public Post(Long id,String description, int likes, String date) {
        this.id = id;
        this.description = description;
        this.likes = likes;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getLikes() {
        return likes;
    }

    public String getDate() {
        return date;
    }
}
