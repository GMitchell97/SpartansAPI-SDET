package com.sparta.spartansapi.cucumber.stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.*;
import com.sparta.spartansapi.injector.Injector;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;

import java.io.IOException;

import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.callManager;
import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.iResponse;

public class CourseCrudStepdefs {

    String id;

    @Given("I have a valid course ID")
    public void iHaveAValidCourseID() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getCourses().getAddCourseUrl(), CallManager.Methods.POST,
                "{\n" +
                        "    \"name\": \"Engineering 99\"\n" +
                        "}");
        iResponse = Injector.injectDTO(callManager);
        id = ((ListOfCourseDTO) iResponse).getCourses().get(0).getId();
    }

    @When("I make a request to add a course with correct fields")
    public void iMakeARequestToAddACourseWithCorrectFields() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getCourses().getAddCourseUrl(), CallManager.Methods.POST,
                "{\n" +
                        "    \"name\": \"Engineering 99\"\n" +
                        "}");
        iResponse = Injector.injectDTO(callManager);
        id = ((ListOfCourseDTO) iResponse).getCourses().get(0).getId();
    }


    @Then("I get back the new course")
    public void iGetBackTheNewCourse() {
        Assertions.assertEquals(id, ((ListOfCourseDTO) iResponse).getCourses().get(0).getId());
    }

    @When("I make a request to add a course with incorrect fields")
    public void iMakeARequestToAddACourseWithIncorrectFields() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getCourses().getAddCourseUrl(), CallManager.Methods.POST,
                "{\n" +
                        "    \"name\": \"Ceramics 3\"\n" +
                        "}");
        iResponse = Injector.injectDTO(callManager);
    }

    @When("I make a valid PUT request to an existing courseId")
    public void iMakeAValidPUTRequestToAnExistingCourseId() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getCourses().getCourseUpdateUrl(id), CallManager.Methods.PATCH,
                "    {\n" +
                        "    \"name\": \"Engineering 100\"\n" +
                        "    }");
        iResponse = Injector.injectDTO(callManager);
    }

    @When("I make a valid PUT request to a non-existing courseId")
    public void iMakeAValidPUTRequestToANonExistingCourseId() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getCourses().getCourseUpdateUrl("invalid-id"), CallManager.Methods.PATCH,
                "    {\n" +
                        "    \"name\": \"Engineering 97 New Group\"\n" +
                        "    }");
        iResponse = Injector.injectDTO(callManager);
    }


    @Then("the course should be updated")
    public void theCourseShouldBeUpdated() {
        Assertions.assertEquals("Engineering 100", ((ListOfCourseDTO) iResponse).getCourses().get(0).name);
    }

    @When("I make a request to remove a course with invalid ID")
    public void iMakeARequestToRemoveACourseWithInvalidID() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getCourses().getCourseDeleteUrl("invalid-id"), CallManager.Methods.DELETE);
        iResponse = Injector.injectDTO(callManager);
    }

    @When("I make a request to remove a course with valid ID")
    public void iMakeARequestToRemoveACourseWithValidID() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getCourses().getCourseDeleteUrl(id), CallManager.Methods.DELETE);
        iResponse = Injector.injectDTO(callManager);
    }

    @After
    public void teardown() throws IOException, InterruptedException {
        if (id != null) {
            CallManager callManager = new CallManager(ConnectionManager.getCourses().getCourseDeleteUrl(id), CallManager.Methods.DELETE);
            Assumptions.assumeTrue(callManager.getStatusCode() == 200);
        }
    }

}
