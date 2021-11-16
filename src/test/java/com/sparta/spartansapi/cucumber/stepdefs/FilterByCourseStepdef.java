package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.IResponse;
import com.sparta.spartansapi.dto.SpartanDTO;
import com.sparta.spartansapi.injector.Injector;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;

import java.util.List;

import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.callManager;

public class FilterByCourseStepdef {

    public static CallManager callManager;
    private boolean isPresent;
    private List<SpartanDTO> spartans;
    @When("I make a valid request by course name {string}")
    public void iMakeAValidRequestByCourseName(String courseName) {
        callManager = new CallManager(ConnectionManager.getSpartan().getByCourse(courseName));
        spartans= (List<SpartanDTO>) Injector.injectDTO(callManager);
    }

    @Then("I get back a list of Spartans that contain the course name {string}")
    public void iGetBackAListOfSpartansThatContainTheCourseName(String expectedCourse){
        isPresent=true;
        for (SpartanDTO spartan:
             spartans) {
            if (!spartan.getCourse().contains(expectedCourse)){
                isPresent=false;
            }
        }
        Assertions.assertTrue(isPresent);
    }

}
