package com.example.Project.Service.impl;

import com.example.Project.DAO.CampaignDAO;
import com.example.Project.Model.Campaign;
import com.example.Project.Service.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService implements ICampaignService {

    private final CampaignDAO campaignRepo;

    @Autowired
    public CampaignService(CampaignDAO theCampaignRepo){campaignRepo = theCampaignRepo;}

    @Override
    public Campaign createCampaign(Campaign campaign) {
        return campaignRepo.save(campaign);
    }

    @Override
    public Campaign updateCampaign(Campaign campaign) {
        return campaignRepo.save(campaign);
    }

    @Override
    public Campaign getCampaign(Long id) {
        return campaignRepo.getReferenceById(id);
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepo.findAll();
    }

    @Override
    public void deleteCampaign(Long id) {
        campaignRepo.deleteById(id);
    }

    @Override
    public boolean doesCampaignIdExist(Long id) {
        return campaignRepo.existsById(id);
    }
}
