package com.sourjelly.snsproject.like.repository;

import com.sourjelly.snsproject.like.domain.Like;
import com.sourjelly.snsproject.like.domain.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, LikeId> {

//    SELECT COUNT(*) FROM `like` WHERE `post_id` = 13;
    public int countByPostId(long postId);
    // 존재여부를 확인해주는 쿼리도 있음
    public boolean existsByUserIdAndPostId(long userId, long postId);

    public Like findByUserIdAndPostId(long userId, long postId);

}

