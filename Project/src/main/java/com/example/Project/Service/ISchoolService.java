package com.example.Project.Service;

import com.example.Project.Model.School;

import java.util.List;

public interface ISchoolService {
    void save(School school);
    void delete(Long id);
    void update(School school);
    School findById(Long id);
    School findByEmail(String email);
    List<School> findAll();
}
