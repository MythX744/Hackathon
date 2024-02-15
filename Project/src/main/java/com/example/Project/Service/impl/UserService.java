package com.example.Project.Service.impl;

import com.example.Project.Model.User;
import com.example.Project.Service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long userId) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void deleteById(Long userId) {

    }

    @Override
    public User login(String username, String password) {
        return null;
    }
}
