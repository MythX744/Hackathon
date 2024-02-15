package com.example.Project.Service.impl;

import com.example.Project.DAO.UserDAO;
import com.example.Project.Model.User;
import com.example.Project.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserDAO userRepo;

    @Autowired
    public UserService(UserDAO theUserRepo){userRepo = theUserRepo;}

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long userId) {
        return userRepo.getReferenceById(userId);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User login(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public boolean doesUserIdExist(Long id) {
        return userRepo.existsById(id);
    }

    @Override
    public int countUsersByProfile(String profile) {
        return userRepo.countByProfile(profile);
    }

    @Override
    public void updateActionTimeByUser(User user) {
        user.setActionTime(LocalDateTime.now());
        userRepo.save(user);
    }

    @Override
    public List<User> getLastActiveUsers(int count) {
        return userRepo.findLastActiveUsers(count);
    }

}
