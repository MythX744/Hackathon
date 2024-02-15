package com.example.Project.Service.impl;

import com.example.Project.DAO.ResponseFormDAO;
import com.example.Project.Model.Message;
import com.example.Project.Model.ResponseForm;
import com.example.Project.Service.IResponseFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseFormService implements IResponseFormService {

    ResponseFormDAO responseFormDAO;

    @Autowired
    public ResponseFormService(ResponseFormDAO responseFormDAO) {
        this.responseFormDAO = responseFormDAO;
    }

    @Override
    public void save(ResponseForm responseForm) {
        responseFormDAO.save(responseForm);
    }

    @Override
    public ResponseForm findById(Long id) {
        Optional<ResponseForm> result = responseFormDAO.findById(id);

        ResponseForm responseForm = null;

        if (result.isPresent()) {
            responseForm = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return responseForm;
    }

    @Override
    public void deleteById(Long id) {
        responseFormDAO.deleteById(id);
    }

    @Override
    public void update(ResponseForm responseForm) {
        responseFormDAO.save(responseForm);
    }

    @Override
    public List<ResponseForm> findAll() {
        return responseFormDAO.findAll();
    }


}
