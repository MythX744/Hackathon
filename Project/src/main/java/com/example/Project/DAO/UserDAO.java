package com.example.Project.DAO;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Long> {
   User findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
    int countByProfile(String profile);

    //List<User> findLastActiveUsers(int count);


}
