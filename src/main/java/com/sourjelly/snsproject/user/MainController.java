package com.sourjelly.snsproject.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/main")
@Controller
public class MainController {


    @GetMapping("/list")
    public String list(){
        return "main/list";
    }

}
