package com.example.Project.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project.Model.School;

import java.util.Optional;

public interface SchoolDAO extends JpaRepository<School, Long>{
    Optional<Object> findByEmail(String email);
}
