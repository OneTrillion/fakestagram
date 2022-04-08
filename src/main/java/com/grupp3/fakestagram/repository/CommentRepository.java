package com.grupp3.fakestagram.repository;

import com.grupp3.fakestagram.model.Comment;
import com.grupp3.fakestagram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


}
