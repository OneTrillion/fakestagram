package com.grupp3.fakestagram.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.grupp3.fakestagram.dao.PostDAO;
import com.grupp3.fakestagram.dao.UserDAO;
import com.grupp3.fakestagram.model.Post;
import com.grupp3.fakestagram.model.User;
import com.grupp3.fakestagram.security.AuthenticationFacade;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostService {
    private PostDAO postDAO;
    private UserDAO userDAO;
    private AuthenticationFacade authenticationFacade;

    //TODO code duplication fix VVVV
    private Long getCurrentUserId() {
        Authentication authentication = authenticationFacade.getAuthentication();
        User currentUser = userDAO.selectUserByUsername(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User with that name not found"));
        return currentUser.getId();
    }


    public Post makePost(Post post){ //klar
        Long currentUserId = getCurrentUserId();
        post.setUserId(currentUserId);
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

    private boolean checkIfPostIsLikedById(Post post, Long userId) {
        List<Long> usersThatLiked = post.getLikedByUser();
        return usersThatLiked.contains(userId);
    }

    public void likePost(Long id){
        Long userId = getCurrentUserId();
        Post post = findPostById(id);
        boolean isLiked = checkIfPostIsLikedById(post, userId);

        if (!isLiked) {
            post.getLikedByUser().add(userId);
            postDAO.likePost(post);
        }
        //TODO kanske lägg till error message om man redan har likeat


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
    }

    //TODO duplicate code fixa (Samma som like med liten skildnad)
    public void unlikePost(Long id){
        Long userId = getCurrentUserId();
        Post post = findPostById(id);
        boolean isLiked = checkIfPostIsLikedById(post, userId);

        if (isLiked) {
            post.getLikedByUser().remove(userId);
            postDAO.unlikePost(post);
        }
    }

    public void updatePostById(String newPostDesc, Long id) {
        //JSONPObject jasonString = new JSONPObject(newPostDesc, id);
        postDAO.updatePostById(newPostDesc,id );
    }
}
