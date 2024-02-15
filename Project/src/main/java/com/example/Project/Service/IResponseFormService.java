package com.example.Project.Service;

import com.example.Project.Model.ResponseForm;

public interface IResponseFormService {
    void save(ResponseForm responseForm);
    ResponseForm findById(Long id);
    void deleteById(Long id);
    void update(ResponseForm responseForm);
    java.util.List<ResponseForm> findAll();

}
