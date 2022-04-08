package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.CommentDAO;
import com.grupp3.fakestagram.model.Comment;
import org.springframework.stereotype.Service;

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
}
