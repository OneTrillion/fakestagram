package com.grupp3.fakestagram.model;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserInfo {

    private String name;
    private Integer age;
    private String bio;
    private String profilePicturePath;
    private String username;
    private List<Long> followerIds;
    private List<Long> followingIds;
}
