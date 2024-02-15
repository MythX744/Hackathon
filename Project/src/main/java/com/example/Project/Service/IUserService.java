package com.example.Project.Service;
import com.example.Project.Model.User;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);

    User save(User user);

    void update(User user);

    void deleteById(Long userId);

    User login(String email, String password);

    User findByEmail(String email);

    boolean doesUserIdExist(Long id);

    int countUsersByProfile(String profile);

    void updateActionTimeByUser(User user);

    User validateUser(String email, String password);


    //List<User> getLastActiveUsers(int count);
}
