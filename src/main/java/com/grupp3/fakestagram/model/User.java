package com.grupp3.fakestagram.model;

public class User {
    private Long id;
    private String  name;
    private int age;
    private int followers;
    private int following;
    private int posts;
    private String bio;
    private String username;
    private String password;

    public User(Long id,String name, int age, int followers, int following, int posts, String bio, String username, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.bio = bio;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public int getPosts() {
        return posts;
    }

    public String getBio() {
        return bio;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
