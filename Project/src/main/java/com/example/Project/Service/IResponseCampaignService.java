package com.example.Project.Service;

import com.example.Project.Model.Campaign;
import java.util.List;

public interface IResponseCampaignService {
    Campaign save(Campaign campaign);

    Campaign getById(Long id);

    List<Campaign> getAll();

    Campaign update(Campaign campaign);

    void delete(Long id);
}