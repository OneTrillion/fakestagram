package com.grupp3.fakestagram.dao;

import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.repository.PostRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAO {
    PostRepository postRepository;

    public PostDAO(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(Post post) {
        postRepository.save(post);

    }
}
