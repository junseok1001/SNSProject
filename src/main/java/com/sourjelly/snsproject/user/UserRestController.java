package com.sourjelly.snsproject.user;

import com.sourjelly.snsproject.user.service.UserService;
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


    // 회원가입
    @PostMapping("/join-process")
    public Map<String, String> join(
            @RequestParam String loginId
            , @RequestParam String password
            , @RequestParam String phoneNumber
            , @RequestParam String email
    ){


        Map<String, String> result = new HashMap<>();
        if(userService.createUser(loginId, password, phoneNumber, email)){
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
