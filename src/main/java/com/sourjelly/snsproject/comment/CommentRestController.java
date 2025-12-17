package com.sourjelly.snsproject.comment;


import com.sourjelly.snsproject.comment.service.CommentService;
import com.sourjelly.snsproject.user.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentRestController {

    private final CommentService commentService;

    public CommentRestController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/post/comment-add")
    public Map<String, String> addComment(
            @RequestParam String comment
            , @RequestParam long postId
            , HttpSession session){

        User user = (User)session.getAttribute("user");

        long userId = user.getId();

        Map<String, String> result = new HashMap<>();
        if(commentService.createComment(postId, userId, comment)){
            result.put("result", "success");
        }else{
            result.put("result", "fail");
        }

        return result;
    }
}
