package com.grupp3.fakestagram.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "name is mandatory")
    private String name;

    @NotNull(message = "age is mandatory")
    private Integer age;

    @NotNull(message = "posts is mandatory")
    private Integer postsAmount;

    @NotEmpty(message = "bio is mandatory")
    private String bio;

    @NotEmpty(message = "profile picture is mandatory")
    private String profilePicturePath;

    @ElementCollection
    private List<Long> followerIds;

    @ElementCollection
    private List<Long> followingIds;

    @NotEmpty(message = "username is mandatory")
    private String username;

    @NotEmpty(message = "password is mandatory")
    private String password;

    @Transient
    private Set<? extends GrantedAuthority> grantedAuthorities;

    @NotNull
    private boolean isAccountNonExpired;

    @NotNull
    private boolean isAccountNonLocked;

    @NotNull
    private boolean isCredentialsNonExpired;

    @NotNull
    private boolean isEnabled;

//TODO fixa detta


    public User(String name, Integer age, Integer postsAmount, String bio, String profilePicturePath, List<Long> followerIds, List<Long> followingIds, String username, String password, Set<? extends GrantedAuthority> grantedAuthorities, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
        this.name = name;
        this.age = age;
        this.postsAmount = postsAmount;
        this.bio = bio;
        this.profilePicturePath = profilePicturePath;
        this.followerIds = followerIds;
        this.followingIds = followingIds;
        this.username = username;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
