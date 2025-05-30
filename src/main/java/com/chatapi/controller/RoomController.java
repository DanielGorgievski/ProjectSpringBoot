package com.chatapi.controller;

import com.chatapi.model.Room;
import com.chatapi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id) {
        return roomService.getRoom(id);
    }

    @GetMapping("/name/{name}")
    public Room getRoomByName(@PathVariable String name) {
        return roomService.getRoomByName(name);
    }
}