package com.sourjelly.snsproject.main.dto;


import com.sourjelly.snsproject.comment.dto.CommentDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PostDto {
    // post table
    private long id;

    private String contents;
    private String imagePath;
    //user table
    private long userId;
    private String name;

    private int likeCount;
    private boolean isLike;

    private List<CommentDto> commentList;

}
