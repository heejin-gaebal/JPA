package com.kh.app13websocket;

import jakarta.websocket.Session;
import jdk.jfr.MemoryAddress;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Map;

@Controller
public class WsController {
    private  final SimpMessageSendingOperations messageSendingOperations;

    public WsController(SimpMessageSendingOperations messageSendingOperations) {
        this.messageSendingOperations = messageSendingOperations;
    }

    @EventListener
    public void m01(SessionConnectEvent event){
        System.out.println("새로운 클라이언트와 연결됨,,,");
    }

    @EventListener
    public void m01(SessionDisconnectEvent disconnectEvent){
        System.out.println("클라이언트와 연결이 끊김,,,");
    }

//    @MessageMapping("/topic")
//    @SendTo("/sub/echo")
//    public String m01(String str){
//        System.out.println("str = " + str);
//        //에코서버
//        return "나는 서버야 : " + str;
//    }

    @MessageMapping("/topic")
    public void m01(Map<String, String> data){
        System.out.println("data = " + data);
//        String x = data.get("nick");
//        System.out.println("x = " + x);
//        String y = data.get("msg");
//        System.out.println("y = " + y);
        messageSendingOperations.convertAndSend("/sub/echo", data);
    }
}
