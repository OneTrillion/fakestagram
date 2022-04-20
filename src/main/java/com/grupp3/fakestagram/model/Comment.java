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
    private String timestamp;

    public Comment(String comment, Long userId, String timestamp) {
        this.comment = comment;
        this.userId = userId;
        this.timestamp = timestamp;
    }
}
