package com.sourjelly.snsproject.websocket;


import com.sourjelly.snsproject.user.domain.User;
import com.sourjelly.snsproject.websocket.test.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class WebsocketController {

    private final ChatService chatService;

    @GetMapping("/message")
    public String messageSelect(Model model){

        List<User> allUser = chatService.findAllUser();

        model.addAttribute("users", allUser);


        return "websocketExample/chatroomlist";
    }


}
