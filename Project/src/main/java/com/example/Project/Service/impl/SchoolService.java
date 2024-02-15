package com.example.Project.Service.impl;

import com.example.Project.DAO.SchoolDAO;
import com.example.Project.Model.School;
import com.example.Project.Service.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements ISchoolService {

    private final SchoolDAO schoolRepo;

    @Autowired
    public SchoolService(SchoolDAO theSchoolRepo){schoolRepo = theSchoolRepo;}

    @Override
    public School save(School school) {
        return schoolRepo.save(school);
    }

    @Override
    public School get(Long id) {
        return schoolRepo.getReferenceById(id);
    }

    @Override
    public List<School> getAll() {
        return schoolRepo.findAll();
    }

    @Override
    public School update(School school) {
        return schoolRepo.save(school);
    }

    @Override
    public void delete(Long id) {
        schoolRepo.deleteById(id);
    }

    @Override
    public School findSchoolByName(String name) {
        return schoolRepo.findByName(name);
    }

    @Override
    public boolean doesSchoolIdExist(Long id) {
        return schoolRepo.existsById(id);
    }
}
