package com.web.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ServerEndpoint(value = "/")
public class ChatEndpoint {
    //ws Session is different from HttpSession
    //@ServerEndpoint 는 클라이언트의 접속마다 인스턴스가 새롭게 생성되기 때문에
    //멤버필드(list) 를 static 으로 구성해둬야 함
    private static List<Session> clients = Collections.synchronizedList(new ArrayList<>());

    //클라이언트가 웹소켓 통신에 대한 욫어을 처음 보낸 순간을 캐치하는 메서드
    Logger logger = LoggerFactory.getLogger(ChatEndpoint.class);

    @OnOpen
    public void onOpen(Session session) { // 접속한 클라이언트의 세션값읆 매개변수로
        clients.add(session); // 접속한 클라이언트의 세션값을 저장
        clients.forEach(e -> logger.info("접속 : " + e));
    }

    // 클라이언트가 웹소켓을 통해 서버와 연결되어 있는 동안 send 라는 함수를 사용했을 때 실행되는 메서드
    @OnMessage
    public void onMessage(Session session, String message) {
        logger.info("message: " + message);
        //for문을 수행하는 도중 clients 를 참조하는 다른 작업이 생기면 for 문을 수행할때까지 대기하도록
        synchronized (clients){
            clients.forEach(
                    // 접속된 클라이언트들에게 메세지 보내기
                    // getBasicRemote() 엔드포인트+클라이언트 사이의 스트림 주소값을 알아낼 수 있는 메서드

                    // 여러 명이 메세지를 주고 받고 있을 때
                    // clients 리스트를 참조해 for 문을 돌리는 도중에 접속이 끊기는 경우
                    // concurrentModificationException 발생(동시성 오류)
                    e -> {
                        try {
                            e.getBasicRemote().sendText(session + " : " + message);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
            );
        }
    }
    // 연결이 끊어졌을 때 실행되는 메서드
    @OnClose
    public void onClose(Session session) {
        logger.info(clients+" 접속종료");
        clients.remove(session);
    }
}
