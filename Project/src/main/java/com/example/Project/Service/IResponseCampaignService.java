package com.example.Project.Service;

import com.example.Project.Model.ResponseCampaign;

import java.util.List;

public interface IResponseCampaignService {
    ResponseCampaign save(ResponseCampaign responseCampaign);

    ResponseCampaign getById(Long id);

    List<ResponseCampaign> getAll();

    ResponseCampaign update(ResponseCampaign responseCampaign);

    void delete(Long id);

    boolean doesResponseCampaignIdExist(Long id);
}