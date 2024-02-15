package com.example.Project.Service;

import com.example.Project.Model.Message;
import java.util.List;

public interface IMessageService {
    Message createMessage(Message message);

    Message getMessage(Long id);

    Message updateMessage(Message message);

    void deleteMessage(Long id);

    List<Message> getAllMessages();

}