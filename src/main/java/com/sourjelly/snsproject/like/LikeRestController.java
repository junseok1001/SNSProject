package com.sourjelly.snsproject.like;


import com.sourjelly.snsproject.like.service.LikeService;
import com.sourjelly.snsproject.user.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LikeRestController {

    private final LikeService likeService;

    public LikeRestController(LikeService likeService){
        this.likeService = likeService;
    }


    @PostMapping("/post/like")
    public Map<String, String>  like(
            @RequestParam long postId
            , HttpSession session){

        User user = (User)session.getAttribute("user");
        long userId = user.getId();

        Map<String , String> resultMap = new HashMap<>();
        if(likeService.createLike(postId, userId)){
            resultMap.put("result", "success");
        }else {
            resultMap.put("result", "fail");
        }

        return resultMap;
    }

}




