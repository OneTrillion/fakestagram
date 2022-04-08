package com.grupp3.fakestagram.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Comment cannot be empty.")
    private String comment;
    private Long userId;
    private Long postId;
    private String timestamp;
    private int likes;

    public Comment(String comment, Long userId, Long postId, String timestamp, int likes) {
        this.comment = comment;
        this.userId = userId;
        this.postId = postId;
        this.timestamp = timestamp;
        this.likes = likes;
    }
}
