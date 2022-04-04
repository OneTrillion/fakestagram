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


    public List<Post> viewAllPosts(){ //klar
        return postDAO.viewAllPosts();

    }

    public Post findPostById(Long id){   //Klar
        // optional hjälper oss undvika null värden (inbyggd if-stats bland annat) kanske lägga in senare
        return postDAO.findPostById(id).get();

    }

    public void deletePostById(Long id){ //Klar
        postDAO.deletePostById(id);
    }

    public void likePost(){

    }

    public void unlikePost(){

    }

    public void updatePostById(Post post){

    }

}
