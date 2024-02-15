package com.example.Project.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project.Model.User;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
   User findByEmailAndPassword(String email, String password);
   User findByEmail(String email);
    int countByProfile(String profile);

    //List<User> findLastActiveUsers(int count);
}
