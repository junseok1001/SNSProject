package com.sourjelly.snsproject.main;


import com.sourjelly.snsproject.main.domain.Post;
import com.sourjelly.snsproject.main.dto.PostDto;
import com.sourjelly.snsproject.main.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/main")
@Controller
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService){
        this.mainService = mainService;
    }

    @GetMapping("/list")
    public String timeline(Model model){

        List<PostDto> postDtoList = mainService.PostList();

        model.addAttribute("posts", postDtoList);



        return "main/list";
    }

    @GetMapping("/add")
    public String formInput(){
        return "main/form";
    }

}
