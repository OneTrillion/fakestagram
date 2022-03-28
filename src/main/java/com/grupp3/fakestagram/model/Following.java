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
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long eachFollowingId;

    public Following(Long userId, Long eachFollowingId) {
        this.userId = userId;
        this.eachFollowingId = eachFollowingId;
    }
}
