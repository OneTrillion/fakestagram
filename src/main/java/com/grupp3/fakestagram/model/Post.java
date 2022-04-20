package com.grupp3.fakestagram.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;
    private String description;

    @ElementCollection
    private List<Long> likedByUser;

    private String date;
    private String img;

    @JoinTable
    @OneToMany
    private List<Comment> comments;

    public Post(Long userId, String description, List<Long> likedByUser, String date, String img, List<Comment> comments) {
        this.userId = userId;
        this.description = description;
        this.likedByUser = likedByUser;
        this.date = date;
        this.img = img;
        this.comments = comments;
    }
}
