package com.grupp3.fakestagram.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
    private UUID userId;
    private UUID postId;
    private int likes;


    public Comment(String comment, UUID userId, UUID postId, int likes) {
        this.comment = comment;
        this.userId = userId;
        this.postId = postId;
        this.likes = likes;
    }

}
