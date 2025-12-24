package com.sourjelly.snsproject.websocket.test.service;

import com.sourjelly.snsproject.user.domain.User;
import com.sourjelly.snsproject.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final UserService  userService;

    public List<User> findAllUser(){
        return userService.findAllUser();
    }

}
