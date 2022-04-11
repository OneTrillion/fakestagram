package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.CommentDAO;
import com.grupp3.fakestagram.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    CommentDAO commentDAO;

    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public Comment submitComment(Comment comment) {
        return commentDAO.submitComment(comment);
    }

    public void likeComment(){

    }

    public Comment findCommentById(Long id) {
        return commentDAO.findCommentById(id).orElse(null);
    }

    public List<Comment> findCommentByUserId(Long id) {
        return commentDAO.findCommentByUserId(id);
    }

    public void deleteCommentById(Long id) {
        commentDAO.deleteCommentById(id);

    }

    public void updateCommentById(String newComment, Long id) {
        commentDAO.updateCommentById(newComment, id);
    }
}
