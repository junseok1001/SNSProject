package com.sourjelly.snsproject.main.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostDto {

    private long id;

    private String contents;
    private String imagePath;

    private long userId;
    private String name;

}
