package com.sourjelly.snsproject.main;


import com.sourjelly.snsproject.comment.service.CommentService;
import com.sourjelly.snsproject.main.dto.PostDto;
import com.sourjelly.snsproject.main.service.MainService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/main")
@Controller
public class MainController {

    private final MainService mainService;
    private final CommentService commentService;

    public MainController(MainService mainService, CommentService commentService ){
        this.mainService = mainService;
        this.commentService = commentService;
    }

    @GetMapping("/list")
    public String timeline(
            Model model
            , HttpSession session){

        List<PostDto> postDtoList = mainService.PostList(session);



        model.addAttribute("posts", postDtoList);
        


        return "main/list";
    }

    @GetMapping("/add")
    public String formInput(){
        return "main/form";
    }

}
