package com.example.Project.Service;


import com.example.Project.Model.Campaign;

import java.util.List;

public interface ICampaignService {

    List<Campaign> findAll();
    Campaign findById(Long id);
    Campaign save(Campaign campaign);
    void deleteById(Long id);
}
