package com.grupp3.fakestagram.repository;

import com.grupp3.fakestagram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Override
    Optional<Post> findById(Long id);

    @Override
    void deleteById(Long aLong);

    List<Post> findByUserId(Long userId);

  /*  @Modifying
    @Query("UPDATE Post post SET post.description = ?1 WHERE post.id = ?2")
    void setNewPostBio(String newPostDesc, Long id);*/

    @Transactional
    @Modifying
    @Query("update Post p set p.description = ?1 where p.id = ?2")
    void updateDescriptionById(String description, Long id);


    







}
