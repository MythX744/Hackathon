package com.example.Project.Service.impl;

import com.example.Project.DAO.ResponseCampaignDAO;
import com.example.Project.Model.ResponseCampaign;
import com.example.Project.Model.User;
import com.example.Project.Service.IResponseCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseCampaignService implements IResponseCampaignService {
    ResponseCampaignDAO responseCampaignDao;

    @Autowired
    public ResponseCampaignService(ResponseCampaignDAO responseCampaignDao) {
        this.responseCampaignDao = responseCampaignDao;
    }

    public void saveResponseCampaign(ResponseCampaign responseCampaign) {
        responseCampaignDao.save(responseCampaign);
    }

    public List<ResponseCampaign> findAll() {
        return responseCampaignDao.findAll();
    }

    @Override
    public ResponseCampaign findById(Long id) {
        Optional<ResponseCampaign> result = responseCampaignDao.findById(id);

        ResponseCampaign responseCampaign = null;

        if (result.isPresent()) {
            responseCampaign = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return responseCampaign;
    }

    public void deleteById(Long id) {
        responseCampaignDao.deleteById(id);
    }

}
