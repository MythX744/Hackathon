package com.example.Project.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project.Model.User;

public interface UserDAO extends JpaRepository<User, Long> {
}
