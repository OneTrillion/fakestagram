package com.grupp3.fakestagram.dao;

import com.grupp3.fakestagram.model.Comment;
import com.grupp3.fakestagram.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentDAO {
    CommentRepository commentRepository;

    public CommentDAO(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment submitComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> findCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findCommentByUserId(Long id) {
        return commentRepository.findByUserId(id);
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    public void updateCommentById(String newComment, Long id) {
        commentRepository.updateCommentById(newComment,id);
    }
}
