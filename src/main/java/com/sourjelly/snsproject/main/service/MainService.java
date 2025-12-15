package com.sourjelly.snsproject.main.service;

import com.sourjelly.snsproject.common.FileManger;
import com.sourjelly.snsproject.main.Repository.MainRepository;
import com.sourjelly.snsproject.main.domain.Post;
import com.sourjelly.snsproject.main.dto.PostDto;
import com.sourjelly.snsproject.user.domain.User;
import com.sourjelly.snsproject.user.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    private final MainRepository mainRepository;

    private final UserService userService;

    public MainService(MainRepository mainRepository, UserService userService){
        this.mainRepository = mainRepository;
        this.userService = userService;
    }

    // 게시물 추가부터
    public boolean createPost(
            long userId
            , String title
            , String contents
            , MultipartFile imageFile){

        String imagePath = FileManger.saveFile(userId, imageFile);

        Post post = Post.builder()
                .userId(userId)
                .title(title)
                .contents(contents)
                .imagePath(imagePath)
                .build();

        try{
            mainRepository.save(post);
        }catch(DataAccessException e){
            return false;
        }

        return true;
    }


//     게시물 전체정보 가져오기
    public List<PostDto> PostList(){


        List<Post> postList = mainRepository.findAll(Sort.by("id").descending());

        List<PostDto> postDtoList = new ArrayList<>();
        for(Post post: postList){
            // post -> postDto로 변환
            // 1 + N 문제 : cache로 극복
            User user = userService.getUserById(post.getUserId());

            PostDto postDto = PostDto.builder()
                    .id(post.getId())
                    .contents(post.getContents())
                    .imagePath(post.getImagePath())
                    .userId(post.getUserId())
                    .name(user.getName())
                    .build();

            postDtoList.add(postDto);
        }

        return postDtoList;
    }



}
