package com.chatapi.service;

import com.chatapi.model.Message;
import com.chatapi.model.Room;
import com.chatapi.model.User;
import com.chatapi.repository.MessageRepository;
import com.chatapi.repository.RoomRepository;
import com.chatapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(Long userId, Long roomId, String content) {
        User user = userRepository.findById(userId).orElseThrow();
        Room room = roomRepository.findById(roomId).orElseThrow();
        Message message = new Message(content, user, room);
        return messageRepository.save(message);
    }

    public List<Message> getMessagesByRoom(Long roomId) {
        return messageRepository.findByRoomId(roomId);
    }
}