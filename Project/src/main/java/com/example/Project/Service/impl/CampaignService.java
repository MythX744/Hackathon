package com.example.Project.Service.impl;

import com.example.Project.DAO.CampaignDAO;
import com.example.Project.Model.Campaign;
import com.example.Project.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Project.Service.*;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService implements ICampaignService{
    CampaignDAO campaignDAO;

    @Autowired
    public CampaignService(CampaignDAO campaignDAO) {
        this.campaignDAO = campaignDAO;
    }

    @Override
    public List<Campaign> findAll() {
        return campaignDAO.findAll();
    }

    @Override
    public Campaign findById(Long id) {
        Optional<Campaign> result = campaignDAO.findById(id);

        Campaign campaign = null;

        if (result.isPresent()) {
            campaign = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return campaign;
    }

    @Override
    public Campaign save(Campaign campaign) {
        return campaignDAO.save(campaign);
    }

    @Override
    public void deleteById(Long id) {
        campaignDAO.deleteById(id);
    }
}
