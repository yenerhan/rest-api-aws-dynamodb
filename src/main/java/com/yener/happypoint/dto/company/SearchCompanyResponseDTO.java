package com.yener.happypoint.dto.company;

import java.util.List;

public class SearchCompanyResponseDTO {

    private List<CompanyDTO> companyDTOList;

    public SearchCompanyResponseDTO() {
    }

    public List<CompanyDTO> getCompanyDTOList() {
        return companyDTOList;
    }

    public void setCompanyDTOList(List<CompanyDTO> companyDTOList) {
        this.companyDTOList = companyDTOList;
    }
}
