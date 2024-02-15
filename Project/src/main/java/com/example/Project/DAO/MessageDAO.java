package com.example.Project.DAO;

import com.example.Project.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDAO extends JpaRepository<Message, Long> {
}
