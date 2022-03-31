package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.Comment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController

@RequestMapping("/api/v1/comment")
public class CommentController {

    @GetMapping("/testcomment")
    public Comment viewComment(){
        Comment testComment = new Comment("Fan vilken snygg bild",UUID.randomUUID(),UUID.randomUUID(),45);
        return testComment;
    }

}
