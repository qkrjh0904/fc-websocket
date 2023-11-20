package com.example.fc.websocket.config

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class HelloWebSocketHandler: TextWebSocketHandler() {
    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println("Received message: ${message.payload}")
        session.sendMessage(TextMessage("Hello from server"))
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        println("New connection: ${session.id}")
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        println("Closed connection: ${session.id}")
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        println("Error for connection: ${session.id}")
    }

}