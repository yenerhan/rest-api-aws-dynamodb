package com.yener.happypoint.dto.company;


public class SearchCompanyRequestDTO {

    private String companyName;
    private Boolean active;

    public SearchCompanyRequestDTO() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
