package com.grupp3.fakestagram.service;

import com.grupp3.fakestagram.dao.PostDAO;
import com.grupp3.fakestagram.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    PostDAO postDAO;

    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public void makePost(Post post){ //klar
        postDAO.savePost(post);
    }

    public void editPost(Post post){

    }

    public List<Post> viewAllPosts(){ //klar
        return postDAO.viewAllPosts();

    }

    public Post findPostById(Long id){ // optional hjälper oss undvika null värden (inbyggd if-stats bland annat)
        //fixa
        postDAO.findPostById(id)
                .orElse(new Post());
        return postDAO.findPostById(id).get();

    }


    public Post deletePostById(Long id){
       return null;

    }

    public void likePost(){

    }

    public void unlikePost(){

    }
}
