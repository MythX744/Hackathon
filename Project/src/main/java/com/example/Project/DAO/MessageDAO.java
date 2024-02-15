package com.example.Project.DAO;

import com.example.Project.Model.Message;

import com.example.Project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDAO extends JpaRepository<Message, Long> {

    List<Message> findMessagesBySender(User sender);
    List<Message> findMessagesByReceiver(User sender);
    List<Message> findMessagesBySenderAndReceiver(User sender, User receiver);
}
