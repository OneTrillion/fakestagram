package com.grupp3.fakestagram.repository;

import com.grupp3.fakestagram.model.Comment;
import com.grupp3.fakestagram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


    @Override
    Optional<Comment> findById(Long id);

    @Override
    void deleteById(Long aLong);

    List<Comment> findByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("update Comment c set c.comment = ?1 where c.id = ?2")
    void updateCommentById(String comment, Long id);






}
