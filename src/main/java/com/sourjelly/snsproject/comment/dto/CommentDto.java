package com.sourjelly.snsproject.comment.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentDto {


    private long id;
    private long postId;
    private String comment;


    private String userName;



}
