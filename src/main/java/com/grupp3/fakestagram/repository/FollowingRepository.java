package com.grupp3.fakestagram.repository;

import com.grupp3.fakestagram.model.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Long> {
}
