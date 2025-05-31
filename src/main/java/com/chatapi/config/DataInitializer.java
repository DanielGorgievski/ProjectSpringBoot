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

            User user1 = new User("Daniel", "daniel@gmail.com");
            User user2 = new User("Sara", "sara@yahoo.com");
            User user3 = new User("Tino", "tino@outlook.com");

            userRepository.saveAll(Arrays.asList(user1, user2, user3));

            Room room1 = new Room("General Chat");
            Room room2 = new Room("Tech Discussion");
            Room room3 = new Room("Gaming Room");

            roomRepository.saveAll(Arrays.asList(room1, room2, room3));

            room1.getParticipants().add(user1);
            room1.getParticipants().add(user2);
            room1.getParticipants().add(user3);

            room2.getParticipants().add(user1);
            room2.getParticipants().add(user2);

            room3.getParticipants().add(user2);
            room3.getParticipants().add(user3);

            roomRepository.saveAll(Arrays.asList(room1, room2, room3));

            Message msg1 = new Message("Hey, how is everybody?", user1, room1);
            Message msg2 = new Message("Im doing great, What about you?", user2, room1);
            Message msg3 = new Message("What's going on here?", user3, room1);

            Message msg4 = new Message("Anyone wanna go out?", user1, room2);
            Message msg5 = new Message("Sure! lets go out somewhere.", user2, room2);

            Message msg6 = new Message("Who wants to play some video games?", user2, room3);
            Message msg7 = new Message("Me!", user3, room3);

            messageRepository.saveAll(Arrays.asList(msg1, msg2, msg3, msg4, msg5, msg6, msg7));
        };
    }
}