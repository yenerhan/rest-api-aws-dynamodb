package com.yener.happypoint.service;

import com.yener.happypoint.base.enums.MessageTypeENUM;
import com.yener.happypoint.base.util.Message;
import com.yener.happypoint.dto.star.DeleteStarResponseDTO;
import com.yener.happypoint.dto.star.SaveStarResponseDTO;
import com.yener.happypoint.dto.star.StarDTO;
import com.yener.happypoint.dto.star.UpdateStarResponseDTO;
import com.yener.happypoint.entity.Star;
import com.yener.happypoint.repository.dynamodb.StarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarService {

    @Autowired
    private StarRepository starRepository;

    public List<Star> findAll() {
        return (List<Star>) starRepository.findAll();
    }


    public Star findStarById(String starId) {
        return starRepository.findStarById(starId);
    }


    public SaveStarResponseDTO saveStar(StarDTO starDTO) {
        Star star = new Star();
        BeanUtils.copyProperties(starDTO, star);
        Star savedStar = starRepository.save(star);
        SaveStarResponseDTO saveStarResponseDTO = new SaveStarResponseDTO();
        if (savedStar.getId() != null) {
            List<Message> messageList = new ArrayList();
            messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Başarılı"));
            saveStarResponseDTO.setMessageList(messageList);
        }
        return saveStarResponseDTO;
    }

    public DeleteStarResponseDTO deleteStar(String starId) {
        starRepository.delete(starId);
        DeleteStarResponseDTO deleteStarResponseDTO = new DeleteStarResponseDTO();
        List<Message> messageList = new ArrayList();
        messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Başarıyla Başarılı"));
        deleteStarResponseDTO.setMessageList(messageList);
        return deleteStarResponseDTO;
    }

    public UpdateStarResponseDTO updateStar(StarDTO starDTO) {
        Star star = starRepository.findStarById(starDTO.getId());
        UpdateStarResponseDTO updateStarResponseDTO = new UpdateStarResponseDTO();
        List<Message> messageList = new ArrayList();
        if (star == null) {
            messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Bulunamadı."));
            updateStarResponseDTO.setMessageList(messageList);
            return updateStarResponseDTO;
        }

        BeanUtils.copyProperties(starDTO, star);
        starRepository.save(star);
        messageList.add(new Message(MessageTypeENUM.SUCCESS, "Güncelleme Başarılı."));
        updateStarResponseDTO.setMessageList(messageList);
        return updateStarResponseDTO;
    }


}
