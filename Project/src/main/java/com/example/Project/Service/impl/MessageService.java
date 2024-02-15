package com.example.Project.Service.impl;

import com.example.Project.DAO.MessageDAO;
import com.example.Project.Model.Message;
import com.example.Project.Service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService implements IMessageService {

    MessageDAO messageDAO;

    @Autowired
    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public Message findById(Long id) {
        Optional<Message> result = messageDAO.findById(id);

        Message message = null;

        if (result.isPresent()) {
            message = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return message;
    }

    @Override
    public Message save(Message message) {
        return messageDAO.save(message);
    }

    @Override
    public void deleteById(Long id) {
        messageDAO.deleteById(id);
    }

    public List<Message> findAll() {
        return messageDAO.findAll();
    }

}
