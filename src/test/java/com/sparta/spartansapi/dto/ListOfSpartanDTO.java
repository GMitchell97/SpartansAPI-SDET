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

    /**
     * Checks if spartans in List<SpartanDTO> has the specified stream name
     * @param stream - stream of course the spartan is in
     * @return if all spartans in list have stream
     */
    public boolean isSpartanInStream(String stream){
        for (SpartanDTO spartanDTO: spartans){
            if (!spartanDTO.getStream().equals(stream)){
                return false;
            }
        }
        return true;
    }
}
