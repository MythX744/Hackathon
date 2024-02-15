package com.example.Project.Service;
import com.example.Project.Model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findByEmail(String email);

    User findById(Long id);

    User save(User user);

    void deleteById(Long userId);

    User login(String email, String password);

    boolean doesUserIdExist(Long id);

    int countUsersByProfile(String profile);

    void updateActionTimeByUser(User user);

    //List<User> getLastActiveUsers(int count);
}
