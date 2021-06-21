package com.yener.happypoint.dto.star;

import java.util.List;

public class SearchStarResponseDTO {

    private List<StarDTO> starDTOList;


    public List<StarDTO> getStarDTOList() {
        return starDTOList;
    }

    public void setStarDTOList(List<StarDTO> starDTOList) {
        this.starDTOList = starDTOList;
    }
}
