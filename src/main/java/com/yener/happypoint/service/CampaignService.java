package com.yener.happypoint.service;

import com.yener.happypoint.base.enums.MessageTypeENUM;
import com.yener.happypoint.base.util.Message;
import com.yener.happypoint.dto.campaign.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignService {

    private static List<CampaignDTO> campaignDTOList = new ArrayList<>();
    private static Long id = 0L;

    public SearchCampaignResponseDTO searchCampaign() {
        SearchCampaignResponseDTO campaignResponseDTO = new SearchCampaignResponseDTO();
        campaignResponseDTO.setCampaignDTOList(campaignDTOList);
        return campaignResponseDTO;
    }

    public SaveCampaignResponseDTO saveCampaign(SaveCampaignRequestDTO saveCampaignRequestDTO) {
        SaveCampaignResponseDTO saveCampaignResponseDTO = new SaveCampaignResponseDTO();
        List<Message> messageList = new ArrayList();
        CampaignDTO campaignDTO = new CampaignDTO();
        campaignDTO.setId(++id);
        campaignDTO.setCampaignName(saveCampaignRequestDTO.getCampaignName());
        campaignDTO.setComment(saveCampaignRequestDTO.getComment());
        campaignDTO.setActive(saveCampaignRequestDTO.getActive());
        campaignDTOList.add(campaignDTO);
        messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Başarılı"));
        saveCampaignResponseDTO.setMessageList(messageList);
        return saveCampaignResponseDTO;
    }

    public DeleteCampaignResponseDTO deleteCampaign(DeleteCampaignRequestDTO deleteCampaignRequestDTO) {

        return null;
    }

    public UpdateCampaignResponseDTO updateCampaign(UpdateCampaignRequestDTO updateCampaignRequestDTO) {
        return null;
    }

}
