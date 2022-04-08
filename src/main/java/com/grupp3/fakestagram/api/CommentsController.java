package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.Comment;
import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/comment")
public class CommentsController {

    CommentService commentService;

    @PostMapping("/submit-comment")
    public void submitComment(@NotEmpty @RequestBody Comment comment){
       commentService.submitComment(comment);
    }

   /* @GetMapping("/comment/{id}")
    public Comment showCommentById(@PathVariable Long id){
        return commentService.findCommentById(id);
    }

    @GetMapping("/user-comment/{id}")
    public List<Comment> findCommentByUserId(@PathVariable Long id){
        return commentService.findPostByUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCommentById(@PathVariable Long id){
        commentService.deleteCommentById(id);
    }

    @PutMapping(value = "update/{id}")
    public void updateCommentById(@RequestBody String newComment,@PathVariable Long id){
        commentService.updateCommentById(newComment, id);

    }*/

}
