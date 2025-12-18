package com.sourjelly.snsproject.main;


import com.sourjelly.snsproject.comment.service.CommentService;
import com.sourjelly.snsproject.main.dto.PostDto;
import com.sourjelly.snsproject.main.service.MainService;
import com.sourjelly.snsproject.user.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/main")
@Controller
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService, CommentService commentService ){
        this.mainService = mainService;
    }

    @GetMapping("/list")
    public String timeline(
            Model model
            , HttpSession session){

        User loginUser = (User)session.getAttribute("user");


        List<PostDto> postDtoList = mainService.PostList(loginUser.getId());



        model.addAttribute("posts", postDtoList);
        


        return "main/list";
    }

    @PostMapping("/add")
    public String formInput(){
        return "main/form";
    }

}
