package com.example.Project.Service;

import com.example.Project.Model.Message;
import com.example.Project.Model.User;

import java.util.List;

public interface IMessageService {
    Message createMessage(Message message);

    Message getMessage(Long id);

    Message updateMessage(Message message);

    void deleteMessage(Long id);

    List<Message> getAllMessages();

    List<Message> getMessagesBySender(User sender);

    List<Message> getMessagesByReceiver(User receiver);

    List<Message> getMessagesBySenderAndReceiver(User sender, User receiver);

    boolean doesMessageIdExist(Long id);

}