package com.sourjelly.snsproject.main;


import com.sourjelly.snsproject.main.service.MainService;
import com.sourjelly.snsproject.user.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/add-process")
    public Map<String, String> addPost(
            @RequestParam String title
            , @RequestParam String contents
            , @RequestParam(required = false) MultipartFile imageFile
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

}
