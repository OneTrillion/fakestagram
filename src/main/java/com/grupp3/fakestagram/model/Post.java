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
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @NotEmpty (message = "Description is mandatory")
    private String description;
    private Integer likes;
    @NotEmpty(message = "Please type in date to continue")
    private String date;

    public Post(String description, int likes, String date) {
        this.description = description;
        this.likes = likes;
        this.date = date;
    }

}
