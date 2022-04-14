package com.grupp3.fakestagram.api;

import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.repository.PostRepository;
import com.grupp3.fakestagram.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostsController {
    PostService postService;


    @PostMapping("/make-post") //funkar
    public Long makePost( @Valid @RequestBody Post post){
        return postService.makePost(post).getId();
    }

    @GetMapping("/view-posts") //funkar
    public List<Post> showAllPosts(){
        return postService.viewAllPosts();
    }

    @GetMapping("/post/{id}")//funkar
    public Post showPostById(@PathVariable Long id){
        return postService.findPostById(id);
    }

    @GetMapping("/user-posts/{id}") //funkar
    public List<Post> findPostByUserId(@PathVariable Long id){
        return postService.findPostByUser(id);
    }

    @DeleteMapping("/delete/{id}") //funkar
    public void deletePostById(@PathVariable Long id){
       postService.deletePostById(id);
    }

    @PutMapping(value = "update/{id}", produces = "application/json") //fixa; ( får en 403??)
    public void updatePostDescById(@RequestBody String newPostDesc,@PathVariable Long id){
      postService.updatePostById(newPostDesc, id);

    }

    @PutMapping("add/like")
    public void likePost(){

    }
    @PutMapping("add/unlike")
    public void unlikePost(){

    }

}
