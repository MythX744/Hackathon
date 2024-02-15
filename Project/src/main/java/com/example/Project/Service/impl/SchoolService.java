package com.example.Project.Service.impl;

import com.example.Project.DAO.SchoolDAO;
import com.example.Project.Model.School;
import com.example.Project.Service.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService implements ISchoolService {
    SchoolDAO schoolDAO;

    @Autowired
    public SchoolService(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    @Override
    public void save(School school) {
        schoolDAO.save(school);
    }

    @Override
    public void delete(Long id) {
        schoolDAO.deleteById(id);
    }

    public School findById(Long id) {
        Optional<School> result = schoolDAO.findById(id);

        School school = null;

        if (result.isPresent()) {
            school = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return school;
    }


    @Override
    public void update(School school) {
        schoolDAO.save(school);
    }

    @Override
    public School findByEmail(String email) {
        return (School) schoolDAO.findByEmail(email).orElse(null);
    }

    @Override
    public List<School> findAll() {
        return schoolDAO.findAll();
    }


}
