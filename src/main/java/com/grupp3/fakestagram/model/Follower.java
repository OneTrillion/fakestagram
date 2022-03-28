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
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long eachFollowerId;

    public Follower(Long userId, Long eachFollowerId) {
        this.userId = userId;
        this.eachFollowerId = eachFollowerId;
    }
}
