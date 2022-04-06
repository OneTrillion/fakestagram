package com.grupp3.fakestagram.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserInfo {
    private String name;
    private Integer age;
    private Integer followers;
    private Integer following;
    private Integer posts;
    private String bio;
    private String profilePicturePath;
    private String username;
}
