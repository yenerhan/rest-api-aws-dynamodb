package com.yener.happypoint.dto.company;

public class DeleteCompanyRequestDTO {
    private Long campanyId;

    public DeleteCompanyRequestDTO() {
    }

    public Long getCampanyId() {
        return campanyId;
    }

    public void setCampanyId(Long campanyId) {
        this.campanyId = campanyId;
    }
}
