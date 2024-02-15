package com.example.Project.Service;

import com.example.Project.Model.ResponseForm;
import java.util.List;

public interface IResponseFormService {
    ResponseForm saveResponseForm(ResponseForm responseForm);

    ResponseForm updateResponseForm(ResponseForm responseForm);

    void deleteResponseForm(Long id);

    ResponseForm findResponseFormById(Long id);

    List<ResponseForm> findAllResponseForms();

    boolean doesResponseFormIdExist(Long id);
}