package com.example.Project.Service;

import com.example.Project.Model.Campaign;
import java.util.List;

public interface ICampaignService {
    Campaign createCampaign(Campaign campaign);

    Campaign updateCampaign(Campaign campaign);

    Campaign getCampaign(Long id);

    List<Campaign> getAllCampaigns();

    void deleteCampaign(Long id);

    boolean doesCampaignIdExist(Long id);
}