package com.data.datachange.module.socket.service;

import com.data.datachange.module.socket.model.MessageVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {
    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    private MessageVO messageVO = new MessageVO();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSockets.add(this);

        messageVO.setType(1);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage("有新的连接");

        ObjectMapper mapper = new ObjectMapper();

        String json = "";
        try {
            json = mapper.writeValueAsString(messageVO);
        }catch (Exception e){
            log.error(e.getMessage());
        }

        this.sendMessage(json);
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);

        messageVO.setType(2);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage("由用户离开");

        ObjectMapper mapper = new ObjectMapper();

        String json = "";
        try {
            json = mapper.writeValueAsString(messageVO);
        }catch (Exception e){
            log.error(e.getMessage());
        }

        this.sendMessage(json);

        log.info("【websocket消息】连接断开, 总数:{}", webSockets.size());

    }

    @OnMessage
    public void onMessage(String message){
        messageVO.setType(3);
        messageVO.setUserNum(webSockets.size());
        messageVO.setMessage(message);

        ObjectMapper mapper = new ObjectMapper();

        String json = "";
        try {
            json = mapper.writeValueAsString(messageVO);
        }catch (Exception e){
            log.error(e.getMessage());
        }

        this.sendMessage(json);

        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    private void sendMessage(String message){
        for (WebSocket webSocket : webSockets){
            log.info("【websocket消息】广播消息, message={}", message);

            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
