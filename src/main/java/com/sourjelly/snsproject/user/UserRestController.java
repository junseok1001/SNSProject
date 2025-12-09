package com.sourjelly.snsproject.user;

import com.sourjelly.snsproject.user.domain.User;
import com.sourjelly.snsproject.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService){
        this.userService = userService;
    }

    //로그인
    @PostMapping("/login-process")
    public Map<String, String> login(
            @RequestParam String loginId
            , @RequestParam String password
            , HttpSession session){

        User user = userService.getUser(loginId, password);

        Map<String, String> result = new HashMap<>();
        if(user != null){
            result.put("result", "success");

            session.setAttribute("user", user);
        }else{
            result.put("result", "fail");
        }

        return result;
    }


    // 회원가입
    @PostMapping("/join-process")
    public Map<String, String> join(
            @RequestParam String loginId
            , @RequestParam String password
            , @RequestParam String name
            , @RequestParam String phoneNumber
            , @RequestParam String email
    ){


        Map<String, String> result = new HashMap<>();
        if(userService.createUser(loginId, password, name ,phoneNumber, email)){
            result.put("result", "success");
        }else{
            result.put("result", "fail");
        }
        return result;
    }




    // 중복 확인
    @GetMapping("duplicate-id")
    public Map<String, Boolean> isDuplicate(@RequestParam String loginId){


        Map<String, Boolean> result = new HashMap<>();
        if(userService.isDuplicateId(loginId)){
            result.put("isDuplicate", true);
        }else{
            result.put("isDuplicate", false);
        }


        return result;
    }
}
