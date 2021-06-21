package com.yener.happypoint.controller;

import com.yener.happypoint.dto.campaign.*;
import com.yener.happypoint.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    CampaignService campaignService;

    @RequestMapping(value = "/searchCampaign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    SearchCampaignResponseDTO searchCampaign(){
        return campaignService.searchCampaign();

    }

    @RequestMapping(value = "/saveCampaign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    SaveCampaignResponseDTO saveCompany(@RequestBody SaveCampaignRequestDTO saveCampaignRequestDTO){
        return campaignService.saveCampaign(saveCampaignRequestDTO);
    }

    @RequestMapping(value = "/deleteCampaign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    DeleteCampaignResponseDTO deleteCampaign(@RequestBody DeleteCampaignRequestDTO deleteCampaignRequestDTO){
        DeleteCampaignResponseDTO deleteCampaignResponseDTO = campaignService.deleteCampaign(deleteCampaignRequestDTO);
        return deleteCampaignResponseDTO;
    }

    @RequestMapping(value = "/updateCampaign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    UpdateCampaignResponseDTO updateCampaign(@RequestBody UpdateCampaignRequestDTO updateCampaignRequestDTO){
        UpdateCampaignResponseDTO updateCampaignResponseDTO = campaignService.updateCampaign(updateCampaignRequestDTO);
        return updateCampaignResponseDTO;
    }

}
