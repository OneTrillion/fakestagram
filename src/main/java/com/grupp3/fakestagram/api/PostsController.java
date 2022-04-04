package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostsController {
    PostService postService;


    @PostMapping("/make-post") //funkar
    public void makePost( @Valid @RequestBody Post post){
        postService.makePost(post);

    }

    @GetMapping("/view-posts") //funkar
    public List<Post> showAllPosts(){
        return postService.viewAllPosts();
    }

    @GetMapping("/post-{id}")//funkar
    public Post showPostById(@PathVariable Long id){
        return postService.findPostById(id);
    }

    @DeleteMapping("/delete/{id}") //funkar
    public void deletePostById(@PathVariable Long id){
       postService.deletePostById(id);
    }

    @PutMapping("update/post/{id}")
    public void updatePostById(){

    }

    @PutMapping("add/like")
    public void likePost(){

    }
    @PutMapping("add/unlike")
    public void unlikePost(){

    }

}
