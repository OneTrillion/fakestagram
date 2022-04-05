package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.Comment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentsController {

    @GetMapping("/testcomment")
    public Comment viewComment(){
        Comment testComment = new Comment("Fan vilken snygg bild",123L, 123L,45);
        return testComment;
    }

}
