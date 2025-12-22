package com.sourjelly.snsproject.like.service;

import com.sourjelly.snsproject.like.domain.Like;
import com.sourjelly.snsproject.like.repository.LikeRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }

    // 좋아요 데이터베이스 추가
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
     // 좋아요 수 가져오기
    public int countByPostId(long postId){
        return likeRepository.countByPostId(postId);
    }
    // 좋아요의 여부
    public boolean isLikeByPostIdAndUserId(long userId, long postId){

        return likeRepository.existsByUserIdAndPostId(userId, postId);
    }

    public boolean removeLike(long userId, long postId){

        Like like = likeRepository.findByUserIdAndPostId(userId, postId);

        if(like != null){

            likeRepository.delete(like);

        }else{
            return false;
        }

        return true;
    }
}
