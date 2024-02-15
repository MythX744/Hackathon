package com.example.Project.Service.impl;


import com.example.Project.DAO.ResponseCampaignDAO;
import com.example.Project.Model.Campaign;
import com.example.Project.Model.ResponseCampaign;
import com.example.Project.Service.IResponseCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseCampaignService implements IResponseCampaignService {

    private final ResponseCampaignDAO responseCampaignRepo;

    @Autowired
    public ResponseCampaignService(ResponseCampaignDAO theResponseCampaignRepo){responseCampaignRepo = theResponseCampaignRepo;}

    @Override
    public ResponseCampaign save(ResponseCampaign responseCampaign) {
        return responseCampaignRepo.save(responseCampaign);
    }

    @Override
    public ResponseCampaign getById(Long id) {
        return responseCampaignRepo.getReferenceById(id);
    }

    @Override
    public List<ResponseCampaign> getAll() {
        return responseCampaignRepo.findAll();
    }

    @Override
    public ResponseCampaign update(ResponseCampaign responseCampaign) {
        return responseCampaignRepo.save(responseCampaign);
    }

    @Override
    public void delete(Long id) {
        responseCampaignRepo.deleteById(id);
    }

    @Override
    public boolean doesResponseCampaignIdExist(Long id) {
        return responseCampaignRepo.existsById(id);
    }
}
