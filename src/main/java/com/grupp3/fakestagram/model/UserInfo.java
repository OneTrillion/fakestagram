package com.grupp3.fakestagram.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserInfo {

    //TODO fixa med detta så att den har alla variabler

    private String name;
    private Integer age;
    private Integer followers;
    private Integer following;
    private String bio;
    private String profilePicturePath;
    private String username;
}
