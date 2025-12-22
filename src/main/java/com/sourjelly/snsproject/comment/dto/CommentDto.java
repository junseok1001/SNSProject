package com.sourjelly.snsproject.comment.dto;


import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class CommentDto {

    private String comment;
    private String name;
}
