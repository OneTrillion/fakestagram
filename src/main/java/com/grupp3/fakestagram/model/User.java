package com.grupp3.fakestagram.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "name is mandatory")
    private String name;

    @NotNull(message = "age is mandatory")
    private Integer age;

    @NotNull(message = "followers is mandatory")
    private Integer followers;

    @NotNull(message = "following is mandatory")
    private Integer following;

    @NotNull(message = "posts is mandatory")
    private Integer posts;

    @NotEmpty(message = "bio is mandatory")
    private String bio;

    @NotEmpty(message = "profile picture is mandatory")
    private String profilePicturePath;

    @NotEmpty(message = "username is mandatory")
    private String username;

    @NotEmpty(message = "password is mandatory")
    private String password;


    public User(String name,
                Integer age,
                Integer followers,
                Integer following,
                Integer posts,
                String bio,
                String profilePicturePath,
                String username,
                String password) {
        this.name = name;
        this.age = age;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.bio = bio;
        this.profilePicturePath = profilePicturePath;
        this.username = username;
        this.password = password;
    }
}
