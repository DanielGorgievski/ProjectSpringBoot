package com.chatapi.config;

import com.chatapi.model.Message;
import com.chatapi.model.Room;
import com.chatapi.model.User;
import com.chatapi.repository.MessageRepository;
import com.chatapi.repository.RoomRepository;
import com.chatapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UserRepository userRepository, RoomRepository roomRepository, MessageRepository messageRepository) {
        return args -> {

            User user1 = new User("Alice", "alice@example.com");
            User user2 = new User("Bob", "bob@example.com");
            User user3 = new User("Charlie", "charlie@example.com");

            userRepository.saveAll(Arrays.asList(user1, user2, user3));

            Room room1 = new Room("General Chat");
            Room room2 = new Room("Tech Discussion");
            Room room3 = new Room("Gaming Room");

            roomRepository.saveAll(Arrays.asList(room1, room2, room3));

            // Add users to rooms
            room1.getParticipants().add(user1);
            room1.getParticipants().add(user2);
            room1.getParticipants().add(user3);

            room2.getParticipants().add(user1);
            room2.getParticipants().add(user2);

            room3.getParticipants().add(user2);
            room3.getParticipants().add(user3);

            roomRepository.saveAll(Arrays.asList(room1, room2, room3));

            Message msg1 = new Message("Hey, how's everyone?", user1, room1);
            Message msg2 = new Message("I'm doing great! What about you?", user2, room1);
            Message msg3 = new Message("Just joined! What's going on here?", user3, room1);

            Message msg4 = new Message("Anyone up for some coding challenge?", user1, room2);
            Message msg5 = new Message("Sure! Let's solve some problems.", user2, room2);

            Message msg6 = new Message("Who wants to play some games?", user2, room3);
            Message msg7 = new Message("Count me in!", user3, room3);

            messageRepository.saveAll(Arrays.asList(msg1, msg2, msg3, msg4, msg5, msg6, msg7));
        };
    }
}