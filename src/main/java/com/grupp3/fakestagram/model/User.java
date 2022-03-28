package com.grupp3.fakestagram.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private int followers;
    private int following;
    private int posts;
    private String bio;
    private String username;
    private String password;

    public User(String name, int age, int followers, int following, int posts, String bio, String username, String password) {
        this.name = name;
        this.age = age;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.bio = bio;
        this.username = username;
        this.password = password;
    }
}
