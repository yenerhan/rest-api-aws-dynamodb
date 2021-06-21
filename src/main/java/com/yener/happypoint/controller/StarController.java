package com.yener.happypoint.controller;

import com.yener.happypoint.dto.star.DeleteStarResponseDTO;
import com.yener.happypoint.dto.star.SaveStarResponseDTO;
import com.yener.happypoint.dto.star.StarDTO;
import com.yener.happypoint.dto.star.UpdateStarResponseDTO;
import com.yener.happypoint.entity.Star;
import com.yener.happypoint.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/star")
public class StarController {

    @Autowired
    StarService starService;

    @RequestMapping(value = "/findAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    List<Star> findAll() {
        return starService.findAll();
    }

    @RequestMapping(value = "/findStarById", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    Star searchStar(@RequestBody String starId) {
        return starService.findStarById(starId);
    }

    @RequestMapping(value = "/saveStar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    SaveStarResponseDTO saveStar(@RequestBody StarDTO starDTO) {
        return starService.saveStar(starDTO);
    }

    @RequestMapping(value = "/deleteStar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    DeleteStarResponseDTO deleteStar(@RequestBody String starId) {
        return starService.deleteStar(starId);
    }

    @RequestMapping(value = "/updateStar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    UpdateStarResponseDTO updateStar(@RequestBody StarDTO starDTO) {
        return starService.updateStar(starDTO);
    }

}
