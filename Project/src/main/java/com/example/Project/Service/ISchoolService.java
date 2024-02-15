package com.example.Project.Service;

import com.example.Project.Model.School;
import java.util.List;

public interface ISchoolService {

    School save(School school);

    School get(Long id);

    List<School> getAll();

    School update(School school);

    void delete(Long id);

    School findSchoolByName(String name);
}