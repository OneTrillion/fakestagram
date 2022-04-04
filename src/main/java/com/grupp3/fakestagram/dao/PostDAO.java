package com.grupp3.fakestagram.dao;

import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostDAO {
    PostRepository postRepository;

    public PostDAO(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(Post post){
        postRepository.save(post);

    }

    public List<Post> viewAllPosts(){
        return postRepository.findAll();

    }

    public Optional<Post> findPostById(Long id){
        return postRepository.findById(id);
    }

    public void deletePostById(Long id){
    postRepository.deleteById(id);
    }

    public void updatePostById() {

    }

    public void likePost(){

    }

    public void unlikePost(){

    }
}
