package com.grupp3.fakestagram.controller;

import com.grupp3.fakestagram.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

@RequestMapping("/api/v1/post")
public class PostController {

    @GetMapping("/testpost")
    public Post viewPost(){
        Post testPost = new Post("Här är första inlägget",23,"2022-03-28");
        return testPost;
    }

}
