package com.sourjelly.snsproject.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/main")
@Controller
public class MainController {


    @GetMapping("/list")
    public String timeline(){
        return "main/list";
    }

    @GetMapping("/add")
    public String formInput(){
        return "main/form";
    }

}
