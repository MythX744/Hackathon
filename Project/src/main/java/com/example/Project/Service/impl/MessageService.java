package com.example.Project.Service.impl;


import com.example.Project.DAO.MessageDAO;
import com.example.Project.Model.Message;
import com.example.Project.Model.User;
import com.example.Project.Service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {

    private final MessageDAO messageDAO;

    @Autowired
    public MessageService(MessageDAO theMessageRepo){messageDAO = theMessageRepo;}

    @Override
    public Message createMessage(Message message) {
        return messageDAO.save(message);
    }

    @Override
    public Message getMessage(Long id) {
        return messageDAO.getReferenceById(id);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageDAO.save(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageDAO.deleteById(id);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageDAO.findAll();
    }
    @Override
    public List<Message> getMessagesBySender(User sender) {
        return messageDAO.findMessagesBySender(sender);
    }
    @Override
    public List<Message> getMessagesByReceiver(User receiver) {
        return messageDAO.findMessagesByReceiver(receiver);
    }
    @Override
    public List<Message> getMessagesBySenderAndReceiver(User sender, User receiver) {
        return messageDAO.findMessagesBySenderAndReceiver(sender, receiver);
    }

    @Override
    public boolean doesMessageIdExist(Long id) {
        return messageDAO.existsById(id);
    }
}
