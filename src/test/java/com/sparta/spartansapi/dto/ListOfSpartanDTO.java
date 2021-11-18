package com.sparta.spartansapi.dto;

import java.util.ArrayList;
import java.util.List;

public class ListOfSpartanDTO implements IResponse {
    private List<SpartanDTO> spartans = new ArrayList<>();

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
            if (!spartanDTO.getStream().getName().equals(stream)){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if spartans in List<SpartanDTO> has the specified course name
     * @param course - course the spartan is in
     * @return if all spartans in list have course
     */
    public boolean isSpartanInCourse(String course){
        for (SpartanDTO spartanDTO: spartans){
            if (!spartanDTO.getCourse().getName().equals(course)){
                return false;
            }
        }
        return true;
    }

    public boolean doesSpartanExist(String name){
        for(SpartanDTO spartanDTO: spartans){
            if(!spartanDTO.getFirstName().equals(name)){
                return false;
            }
        }
        return true;
    }

    public String spartanNameConverter (String name) {
        String nname = "";
        for (SpartanDTO spartanDTO : spartans) {
            if (spartanDTO.getMiddleName().isEmpty()) {
                nname = spartanDTO.getFirstName()+"%20"+spartanDTO.getLastName();
            } else {
                nname = spartanDTO.getFirstName()+"%20"+spartanDTO.getMiddleName()+"%20"+spartanDTO.getLastName();
            }
        }
        return nname;
    }

    public boolean isSpartanNameInResponse(String name) {
        for (SpartanDTO spartanDTO : spartans) {
            String nname = spartanNameConverter(name);
            if (!name.equals(nname)) return false;
        }
        return true;
    }
}
