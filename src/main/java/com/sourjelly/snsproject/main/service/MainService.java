package com.sourjelly.snsproject.main.service;

import com.sourjelly.snsproject.common.FileManger;
import com.sourjelly.snsproject.main.Repository.MainRepository;
import com.sourjelly.snsproject.main.domain.Post;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    private final MainRepository mainRepository;

    public MainService(MainRepository mainRepository){
        this.mainRepository = mainRepository;
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


    // 게시물 전체정보 가져오기
    public List<Post> PostList(

        


    }



}
