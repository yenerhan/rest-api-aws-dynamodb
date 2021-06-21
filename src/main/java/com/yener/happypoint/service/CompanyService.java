package com.yener.happypoint.service;

import com.yener.happypoint.base.enums.MessageTypeENUM;
import com.yener.happypoint.base.util.Message;
import com.yener.happypoint.dto.company.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {


    private static List<CompanyDTO> companyDTOList = new ArrayList<>();
    private static Long id = 0L;

    public SearchCompanyResponseDTO getAllCompany() {
        SearchCompanyResponseDTO searchCompanyResponseDTO = new SearchCompanyResponseDTO();
        searchCompanyResponseDTO.setCompanyDTOList(companyDTOList);
        return searchCompanyResponseDTO;
    }

    public SaveCompanyResponseDTO saveCompany(SaveCompanyRequestDTO saveCompanyRequestDTO) {
        SaveCompanyResponseDTO saveCompanyResponseDTO = new SaveCompanyResponseDTO();
        List<Message> messageList = new ArrayList();
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(++id);
        companyDTO.setCompanyName(saveCompanyRequestDTO.getCompanyName());
        companyDTO.setComment(saveCompanyRequestDTO.getComment());
        companyDTO.setActive(saveCompanyRequestDTO.getActive());
        companyDTOList.add(companyDTO);
        messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Başarılı"));
        saveCompanyResponseDTO.setMessageList(messageList);
        return saveCompanyResponseDTO;
    }

    public DeleteCompanyResponseDTO deleteCompany(DeleteCompanyRequestDTO deleteCompanyRequestDTO) {
        return null;
    }

    public UpdateCompanyResponseDTO updateCompany(UpdateCompanyRequestDTO updateCompanyRequestDTO) {
        return null;
    }
}
