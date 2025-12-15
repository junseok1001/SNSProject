package com.sourjelly.snsproject.websocket.test.controller;


import com.sourjelly.snsproject.websocket.test.dto.MessageRequestDto;
import com.sourjelly.snsproject.websocket.test.dto.MessageResponseDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public MessageResponseDto sendMessage(MessageRequestDto requestDto){

        MessageResponseDto responseDto = new MessageResponseDto();
        responseDto.setContent(requestDto.getContent());
        return responseDto;
    }
}
