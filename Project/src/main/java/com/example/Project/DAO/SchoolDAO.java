package com.example.Project.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project.Model.School;

import java.util.List;

public interface SchoolDAO extends JpaRepository<School, Long>{
    School findByName(String name);
    List<School> findSchoolsByCity(String city);
}
