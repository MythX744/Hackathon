package com.example.Project.Service;


import com.example.Project.Model.ResponseCampaign;

import java.util.List;

public interface IResponseCampaignService{
    void saveResponseCampaign(ResponseCampaign responseCampaign);
    void deleteById(Long id);
    ResponseCampaign findById(Long id);
    List<ResponseCampaign> findAll();
}
