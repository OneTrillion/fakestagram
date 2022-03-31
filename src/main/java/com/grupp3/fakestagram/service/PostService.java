package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.PostDAO;
import com.grupp3.fakestagram.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    PostDAO postDAO;

    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public void makePost(Post post){
        postDAO.savePost(post);
    }

    public void viewPosts(){

    }

    public void editPost(){

    }

    public void deletePost(){

    }

    public void likePost(){

    }

    public void unlikePost(){

    }
}
