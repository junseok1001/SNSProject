package com.sourjelly.snsproject.comment.service;


import com.sourjelly.snsproject.comment.domain.Comment;
import com.sourjelly.snsproject.comment.dto.CommentDto;
import com.sourjelly.snsproject.comment.repository.CommentRepository;
import com.sourjelly.snsproject.user.domain.User;
import com.sourjelly.snsproject.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {


    private final CommentRepository commentRepository;
    private final UserService userService;


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
    // 해당 게시글 댓글정보들 모아오기
    public List<CommentDto> getCommentsByPostId(long postId){

        List<Comment> commentList = commentRepository.findByPostId(postId);
        List<CommentDto> commentDtoList = new ArrayList<>();
        for(Comment comment : commentList){

            User user = userService.getUserById(comment.getUserId());

            CommentDto commentDto = CommentDto.builder()
                    .comment(comment.getComment())
                    .name(user.getName())
                    .build();

            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }
    // 해당 게시글 댓글 전체 삭제
    public void deleteCommentByPostId(long postId){
        commentRepository.deleteByPostId(postId);
    }

}
