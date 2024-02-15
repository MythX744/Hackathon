package com.example.Project.Service;

import com.example.Project.Model.School;
import com.example.Project.Model.User;

import java.util.List;

public interface ISchoolService {

    School save(School school);

    School get(Long id);

    List<School> getAll();

    School update(School school);

    void delete(Long id);

    School findByName(String name);

    boolean doesSchoolIdExist(Long id);

    List<School> listSchoolsByCity(String city);

    School findById(Long id);

    Long findIdByName(String schoolName);
}
