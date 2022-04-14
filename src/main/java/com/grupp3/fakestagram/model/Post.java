package com.grupp3.fakestagram.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;
    private String description;

    //TODO fixa detta VVVV
    @ElementCollection
    private List<Long> likedByUser;
    @NotEmpty(message = "Please type in date to continue")
    private String date;
    private String img;

    public Post(Long userId, String description, List<Long> likedByUser, String date, String img) {
        this.userId = userId;
        this.description = description;
        this.likedByUser = likedByUser;
        this.date = date;
        this.img = img;
    }
}
