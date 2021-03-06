package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.CommentDAO;
import com.grupp3.fakestagram.model.Comment;
import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    private CommentDAO commentDAO;

    private CommentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CommentService(commentDAO);
    }

    @Test
    void submitComment() {
        //given
        Comment comment = new Comment("test", 5L, "January");
        //when
        underTest.submitComment(comment);
        //then
        Mockito.verify(commentDAO, Mockito.times(1)).submitComment(comment);
        //times
    }

    @Test
    void findCommentById() {
        //given
        Comment comment = new Comment("test", 5L, "January");
        comment.setId(5L);
        Long commentId = comment.getId();

        Mockito.when(commentDAO.findCommentById(any())).thenReturn(Optional.of(comment));
        //when
        Comment commentById = underTest.findCommentById(commentId);
        //then
        assertEquals(5L,commentById.getId());
    }

    @Test
    void findCommentByUserId() {
        //given
        User user = new User();
        user.setId(5L);
        Long userId = user.getId();
        //when
        underTest.findCommentByUserId(userId);
        //then
        Mockito.verify(commentDAO).findCommentByUserId(user.getId());
    }

    @Test
    void deleteCommentById() {
        //given
        Comment comment = new Comment("test", 5L, "January");
        Long commentId = comment.getId();
        //when
        underTest.deleteCommentById(commentId);
        //then
        Mockito.verify(commentDAO).deleteCommentById(commentId);
    }

    @Test
    void updateCommentById() {
        //given
        Comment comment = new Comment("test", 5L, "Januari");
        Long commentId = comment.getId();
        String newComment = "testtest";
        //when
        underTest.updateCommentById(newComment, commentId);
        //then
        Mockito.verify(commentDAO).updateCommentById(newComment, commentId);
    }
}