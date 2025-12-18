package com.sourjelly.snsproject.websocket.test.controller;



import com.sourjelly.snsproject.websocket.test.dto.MessageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
@RequiredArgsConstructor
@Controller
public class ChatController {



    @RequestMapping("/websocket")
    public String webSocket(){


        return "websocketExample/example";
    }

    private final SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/chat")
    public void sendMessage( @Payload Map<String, Object> data){

        MessageResponseDto responseDto = new MessageResponseDto();
        responseDto.setUserId((String)data.get("sender"));
        responseDto.setContent((String)data.get("contents"));
//        responseDto.setContent(requestDto.getContent());
//        return responseDto;
//        responseDto.setUserId((String)message.get("sender"));
//        responseDto.setContent((String)message.get("contents"));
//        return responseDto;
        simpMessagingTemplate.convertAndSend("/topic/1",responseDto);

    }
}
