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

    public Post savePost(Post post){
        return postRepository.save(post);

    }

    public List<Post> viewAllPosts(){
        return postRepository.findAll();

    }

    public Optional<Post> findPostById(Long id){
        return postRepository.findById(id);
    }

    public List<Post> findPostByUser(Long id){
       return postRepository.findByUserId(id);
    }

    public void deletePostById(Long id){
    postRepository.deleteById(id);
    }

    //TODO duplicate code, gör metod "save post" och refactor
    public void likePost(Post post){
        postRepository.save(post);
    }

    public void unlikePost(Post post){
        postRepository.save(post);
    }

    public void updatePostById(String newPostDesc, Long id) {
        postRepository.updateDescriptionById(newPostDesc, id);
    }
}
