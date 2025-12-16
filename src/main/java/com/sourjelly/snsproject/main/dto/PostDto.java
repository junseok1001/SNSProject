package com.sourjelly.snsproject.main.dto;


import lombok.Builder;
import lombok.Getter;

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

    // comment table
}
