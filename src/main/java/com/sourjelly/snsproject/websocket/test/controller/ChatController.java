package com.sourjelly.snsproject.websocket.test.controller;


import com.sourjelly.snsproject.websocket.test.dto.MessageRequestDto;
import com.sourjelly.snsproject.websocket.test.dto.MessageResponseDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {



    @RequestMapping("/websocket")
    public String webSocket(){


        return "websocketExample/example";
    }


    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public MessageResponseDto sendMessage(@Payload MessageRequestDto requestDto){

        MessageResponseDto responseDto = new MessageResponseDto();
        responseDto.setContent(requestDto.getContent());
        return responseDto;
    }
}
