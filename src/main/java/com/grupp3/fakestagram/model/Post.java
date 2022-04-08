package com.grupp3.fakestagram.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//
    private Long id;
    private String description;
    @NotNull (message = "0")
    private Integer likes;
    @NotEmpty(message = "Please type in date to continue")
    private String date;
    private String img;
    private Long userId;

    public Post(String description, int likes, String date, Long userId, String img) {
        this.description = description;
        this.likes = likes;
        this.date = date;
        this.userId = userId;
        this.img = img;
    }




}
