package com.grupp3.fakestagram.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.grupp3.fakestagram.dao.PostDAO;
import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    PostDAO postDAO;

    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public Post makePost(Post post){ //klar
        return postDAO.savePost(post);
    }


    public List<Post> viewAllPosts(){ //klar
        return postDAO.viewAllPosts();

    }

    public Post findPostById(Long id){   //Klar//
        // optional hjälper oss undvika null värden (inbyggd if-stats bland annat) kanske lägga in senare
        return postDAO.findPostById(id).orElse(null);

    }

    public List<Post> findPostByUser(Long id){//klar
        return postDAO.findPostByUser(id);
    }

    public void deletePostById(Long id){ //Klar
        postDAO.deletePostById(id);
    }

    public Integer likePost(Long id){
     //alla post likes börjar på 0
        // klickar du en gång ökar värdet med 1
        // klickar du igen minskar värdet -1



        /*  ResponseObjectService responseObj = new ResponseObjectService();
        Optional<PostEntity> optPost = postRepo.findById(doubleId.getId1());
        if (optPost.isEmpty()) {
            responseObj.setStatus("fail");
            responseObj.setMessage("cannot find post id: " + doubleId.getId1());
            responseObj.setPayload(null);
            return responseObj;
        } else {
            PostEntity targetPost = optPost.get();
            List<String> loveList = targetPost.getLove();
            if (loveList == null) {
                loveList = new ArrayList<>();
            }
            // love and unlove a post
            if (!loveList.contains(doubleId.getId2())) {
                loveList.add(doubleId.getId2());
            } else {
                loveList.remove(doubleId.getId2());
            }
            targetPost.setLove(loveList);
            postRepo.save(targetPost);
            responseObj.setStatus("success");
            responseObj.setMessage("update love to the target post id: " + targetPost.getId());
            responseObj.setPayload(targetPost);
            return responseObj;
        }*/
        return null;
    }

    public void unlikePost(){

    }

    public void updatePostById(String newPostDesc, Long id) {
        //JSONPObject jasonString = new JSONPObject(newPostDesc, id);
        postDAO.updatePostById(newPostDesc,id );
    }
}
