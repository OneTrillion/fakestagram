package com.grupp3.fakestagram.dao;

import com.grupp3.fakestagram.model.Comment;
import com.grupp3.fakestagram.repository.CommentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
    CommentRepository commentRepository;

    public CommentDAO(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment submitComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
