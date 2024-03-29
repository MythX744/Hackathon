package com.example.Project.Service.impl;

import com.example.Project.DAO.UserDAO;
import com.example.Project.Model.User;
import com.example.Project.Service.IUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Transactional
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
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            // Handle the case where no user is found, e.g., throw an exception or return null
            System.out.println("No user found with email: " + email);
            return null;
        }
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

    public User validateUser(String email, String password) {
        User user = userRepo.findByEmail(email).orElse(null);
        if (user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public void update(User user) {
        userRepo.save(user);
    }

    public List<User> getUsersByProfile(String profile) {
        return userRepo.findByProfile(profile);
    }


/*    @Override
    public List<User> getLastActiveUsers(int count) {
        return userRepo.findLastActiveUsers(count);
    }*/

}
