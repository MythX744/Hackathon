package com.example.Project.Service.impl;


import com.example.Project.Model.Message;
import com.example.Project.Service.IMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {
    @Override
    public Message createMessage(Message message) {
        return null;
    }

    @Override
    public Message getMessage(Long id) {
        return null;
    }

    @Override
    public Message updateMessage(Message message) {
        return null;
    }

    @Override
    public void deleteMessage(Long id) {

    }

    @Override
    public List<Message> getAllMessages() {
        return null;
    }
}
