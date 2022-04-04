package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostsController {
    PostService postService;


    @PostMapping("/make-post") //funkar
    public void makePost(@RequestBody Post post){
        postService.makePost(post);

    }

    @GetMapping("/view")
    public List<Post> showAllPosts(){
        return postService.viewAllPosts();
    }

    @GetMapping("/{id}")
    public Post showPostById(@PathVariable Long id){
        return postService.findPostById(id);
    }

    @GetMapping("/testpost")
    public Post viewPosts(){
        Post testPost = new Post("Här är första inlägget",23,"2022-03-28");
        return testPost;
    }

}
