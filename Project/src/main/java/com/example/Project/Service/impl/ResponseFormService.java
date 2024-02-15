package com.example.Project.Service.impl;

import com.example.Project.DAO.ResponseFormDAO;
import com.example.Project.DAO.SchoolDAO;
import com.example.Project.Model.ResponseForm;
import com.example.Project.Service.IResponseFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseFormService implements IResponseFormService {

    private final ResponseFormDAO responseFormRepo;

    @Autowired
    public ResponseFormService(ResponseFormDAO theResponseFormRepo){responseFormRepo = theResponseFormRepo;}

    @Override
    public ResponseForm saveResponseForm(ResponseForm responseForm) {
        return responseFormRepo.save(responseForm);
    }

    @Override
    public ResponseForm updateResponseForm(ResponseForm responseForm) {
        return responseFormRepo.save(responseForm);
    }

    @Override
    public void deleteResponseForm(Long id) {
        responseFormRepo.deleteById(id);
    }

    @Override
    public ResponseForm findResponseFormById(Long id) {
        return responseFormRepo.getReferenceById(id);
    }

    @Override
    public List<ResponseForm> findAllResponseForms() {
        return responseFormRepo.findAll();
    }
    @Override
    public boolean doesResponseFormIdExist(Long id) {
        return responseFormRepo.existsById(id);
    }
}
