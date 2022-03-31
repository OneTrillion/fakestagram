package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostsController {
    PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/make-post")
    public void makePost(@RequestBody Post post){
        postService.makePost(post);

    }

    @GetMapping("/testpost")
    public Post viewPosts(){
        Post testPost = new Post("Här är första inlägget",23,"2022-03-28");
        return testPost;
    }

}
