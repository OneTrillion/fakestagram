package com.grupp3.fakestagram.repository;

import com.grupp3.fakestagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

   Optional<User> findByUsername(String username);

   @Transactional
   @Modifying
   @Query("UPDATE User user SET user.password = ?1 WHERE user.id = ?2")
   void setNewPasswordByUserId(String newPassword, Long userId);

   @Transactional
   @Modifying
   @Query("UPDATE User user SET user.profilePicturePath = ?1 WHERE user.id = ?2")
   void setNewProfilePicturePathByUserId(String newProfilePicturePath, Long userId);

   @Transactional
   @Modifying
   @Query("UPDATE User user SET user.bio = ?1 WHERE user.id = ?2")
   void setNewBioByUserId(String newBio, Long userId);
}
