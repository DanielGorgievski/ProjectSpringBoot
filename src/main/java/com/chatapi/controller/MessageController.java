package com.chatapi.controller;

import com.chatapi.model.Message;
import com.chatapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message sendMessage(@RequestParam Long userId, @RequestParam Long roomId, @RequestParam String content) {
        return messageService.sendMessage(userId, roomId, content);
    }

    @GetMapping("/room/{roomId}")
    public List<Message> getMessagesByRoom(@PathVariable Long roomId) {
        return messageService.getMessagesByRoom(roomId);
    }
}