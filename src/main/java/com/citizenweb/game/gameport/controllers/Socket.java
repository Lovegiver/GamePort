package com.citizenweb.game.gameport.controllers;

import com.citizenweb.game.gameport.tools.MessageDecoder;
import com.citizenweb.game.gameport.tools.MessageEncoder;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Log
@Component
@ServerEndpoint(value="/gaia",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class)
public class Socket {
    private Session session;
    public static Set<Socket> listeners = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) throws InterruptedException {
        this.session = session;
        listeners.add(this);
        log.info(String.format("New session connected! Connected listeners: %s", listeners.size()));
    }

    @OnMessage //Allows the client to send message to the socket.
    public void onMessage(String message) {
        broadcast(message);
    }

    @OnClose
    public void onClose(Session session) {
        listeners.remove(this);
        log.info(String.format("Session disconnected. Total connected listeners: %s", listeners.size()));
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        //Error
    }

    public static void broadcast(String message) {
        for (Socket listener : listeners) {
            listener.sendMessage(message);
        }
    }

    private void sendMessage(String message) {
        String m = String.format("%s with session %s", message, this.session.toString());
        try {
            this.session.getBasicRemote().sendText(m);
        } catch (IOException e) {
            log.severe("Caught exception while sending message to Session Id: " + this.session.getId());
        }
    }
}
