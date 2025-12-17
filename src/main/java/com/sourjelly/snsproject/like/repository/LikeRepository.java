package com.sourjelly.snsproject.like.repository;

import com.sourjelly.snsproject.like.domain.Like;
import com.sourjelly.snsproject.like.domain.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, LikeId> {

//    SELECT COUNT(*) FROM `like` WHERE `post_id` = 13;
    public int countByPostId(long postId);

    public int countByUserIdAndPostId(long userId, long postId);

}

