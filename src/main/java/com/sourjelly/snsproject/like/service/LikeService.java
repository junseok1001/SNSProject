package com.sourjelly.snsproject.like.service;

import com.sourjelly.snsproject.like.domain.Like;
import com.sourjelly.snsproject.like.repository.LikeRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }


    public boolean createLike(long postId, long userId){

        Like like = Like.builder()
                .postId(postId)
                .userId(userId)
                .build();

        try {
            likeRepository.save(like);
        }catch(DataAccessException e){
            return false;
        }

        return true;
    }

    public int countByPostId(long postId){
        return likeRepository.countByPostId(postId);
    }

    public int countByUserIdAndPostId(long userId, long postId){
        return likeRepository.countByUserIdAndPostId(userId, postId);
    }
}
