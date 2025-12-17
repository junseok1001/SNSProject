package com.sourjelly.snsproject.comment.service;


import com.sourjelly.snsproject.comment.domain.Comment;
import com.sourjelly.snsproject.comment.dto.CommentDto;
import com.sourjelly.snsproject.comment.repository.CommentRepository;
import com.sourjelly.snsproject.user.domain.User;
import com.sourjelly.snsproject.user.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {


    private final CommentRepository commentRepository;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, UserService userService){
        this. commentRepository = commentRepository;
        this.userService = userService;
    }

    // 댓글 작성

    public boolean createComment(long postId, long userId, String comment){

        Comment com = Comment.builder()
                .postId(postId)
                .userId(userId)
                .comment(comment)
                .build();

        try{
            commentRepository.save(com);
        }catch(DataAccessException e){
            return false;
        }

        return true;
    }


}
