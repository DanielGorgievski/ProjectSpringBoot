package com.chatapi.model;

import jakarta.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Message() {}
    public Message(String content, User sender, Room room) {
        this.content = content;
        this.sender = sender;
        this.room = room;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
}