package com.yener.happypoint.dto.campaign;


import com.yener.happypoint.base.restApi.apiResponse.BaseApiResponse;

import java.util.List;

public class SearchCampaignResponseDTO extends BaseApiResponse {
    private List<CampaignDTO> campaignDTOList;


    public SearchCampaignResponseDTO() {
    }

    public List<CampaignDTO> getCampaignDTOList() {
        return campaignDTOList;
    }

    public void setCampaignDTOList(List<CampaignDTO> campaignDTOList) {
        this.campaignDTOList = campaignDTOList;
    }
}
