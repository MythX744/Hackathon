package com.example.Project.Service.impl;
import com.example.Project.DAO.SchoolDAO;
import com.example.Project.Model.School;
import com.example.Project.Model.User;
import com.example.Project.Service.ISchoolService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService implements ISchoolService {

    private SchoolDAO schoolRepo;

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
    public School findByName(String name) {
        return schoolRepo.findByName(name).orElse(null);
    }

    @Override
    public boolean doesSchoolIdExist(Long id) {
        return schoolRepo.existsById(id);
    }

    @Override
    public List<School> listSchoolsByCity(String city) {
        return schoolRepo.findSchoolsByCity(city);
    }

    @Override
    public School findById(Long id) {
        Optional<School> result = schoolRepo.findById(id);

        School school = null;

        if (result.isPresent()) {
            school = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return school;
    }

    public Long findIdByName(String schoolName) {
        return schoolRepo.findIdByName(schoolName).orElse(null);
    }
}
