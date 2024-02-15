package com.example.Project.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project.Model.School;

public interface SchoolDAO extends JpaRepository<School, Long>{
    School findByName(String name);

}
