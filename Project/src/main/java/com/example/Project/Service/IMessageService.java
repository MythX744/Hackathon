package com.example.Project.Service;

import com.example.Project.Model.Message;

import java.util.List;

public interface IMessageService {
    Message findById(Long id);
    Message save(Message message);
    void deleteById(Long id);
    List<Message> findAll();
}
