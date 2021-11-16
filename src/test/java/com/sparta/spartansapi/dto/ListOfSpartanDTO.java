package com.sparta.spartansapi.dto;

import java.util.List;

public class ListOfSpartanDTO implements IResponse {
    private List<SpartanDTO> spartans;

    public List<SpartanDTO> getSpartans() {
        return spartans;
    }
    public void addSpartan(SpartanDTO spartanDTO){
        spartans.add(spartanDTO);
    }

}
