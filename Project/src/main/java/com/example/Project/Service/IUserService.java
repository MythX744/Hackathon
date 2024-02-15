package com.example.Project.Service;
import com.example.Project.Model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long userId);

    User save(User user);

    void deleteById(Long userId);

    User login(String email, String password);

    User findByEmail(String email);

    boolean doesUserIdExist(Long id);
}
