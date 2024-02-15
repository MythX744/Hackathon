package com.example.Project.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project.Model.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SchoolDAO extends JpaRepository<School, Long>{
    Optional<School> findByName(String name);
    List<School> findSchoolsByCity(String city);

    @Query("SELECT s.id FROM School s WHERE s.name = :name")
    Optional<Long> findIdByName(@Param("name") String name);
}
