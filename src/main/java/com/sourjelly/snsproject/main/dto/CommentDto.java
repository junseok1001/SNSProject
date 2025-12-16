package com.sourjelly.snsproject.main.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private long id;
    private String comment;

    private long postId;

    private long userId;
    private String name;
}
