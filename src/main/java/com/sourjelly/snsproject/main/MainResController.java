package com.sourjelly.snsproject.main;


import com.sourjelly.snsproject.main.service.MainService;
import com.sourjelly.snsproject.user.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/post")
@RestController
public class MainResController {

    private final MainService mainService;

    public MainResController(MainService mainService){
        this.mainService = mainService;
    }
    // 게시물 저장
    @PostMapping("/add-process")
    public Map<String, String> addPost(
            @RequestParam String title
            , @RequestParam String contents
            , @RequestParam MultipartFile imageFile
            , HttpSession session){

        User user = (User)session.getAttribute("user");
        long userId = user.getId();


        Map<String, String> resultMap = new HashMap<>();
        if(mainService.createPost(userId, title, contents, imageFile)){
            resultMap.put("result", "success");
        }else{
            resultMap.put("result", "fail");
        }

        return resultMap;

    }

    // 댓글저장 저장
    @GetMapping("/comment-add")
    public Map<String, String> addComment(
            @RequestParam String comment
            , @RequestParam long postId
            , @RequestParam long userId){



    }



}
