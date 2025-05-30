package com.chatapi.repository;

import com.chatapi.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByName(String name);
}