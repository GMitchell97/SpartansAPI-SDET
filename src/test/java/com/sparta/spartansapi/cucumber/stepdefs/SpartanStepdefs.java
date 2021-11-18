package com.sparta.spartansapi.cucumber.stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.ErrorDTO;
import com.sparta.spartansapi.dto.ListOfSpartanDTO;
import com.sparta.spartansapi.dto.SpartanDTO;
import com.sparta.spartansapi.injector.Injector;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.*;

public class SpartanStepdefs {


    @When("I make a valid request by course name {string}")
    public void iMakeAValidRequestByCourseName(String course) throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByCourse(course));
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get back a list of Spartans that contain the course name {string}")
    public void iGetBackAListOfSpartansThatContainTheCourseName(String course) {
        Assertions.assertTrue(((ListOfSpartanDTO) iResponse).isSpartanInCourse(course));
    }

    @When("I search for Spartans who end their contract on a specified full date")
    public void iSearchForSpartansWhoEndTheirContractOnASpecifiedFullDate() {
    }

    @Then("I get a list of Spartans who end their contract on the specified full date")
    public void iGetAListOfSpartansWhoEndTheirContractOnTheSpecifiedFullDate() {
    }

    @When("I search for Spartans who end their contract who end their contract within a specified date range")
    public void iSearchForSpartansWhoEndTheirContractWhoEndTheirContractWithinASpecifiedDateRange() {
    }

    @Then("I get a list of Spartans who end their contract within the specified date range")
    public void iGetAListOfSpartansWhoEndTheirContractWithinTheSpecifiedDateRange() {
    }

    @When("I search for Spartans who end their contract on an invalid full date")
    public void iSearchForSpartansWhoEndTheirContractOnAnInvalidFullDate() {
    }


    @When("I make a valid request by id {string}")
    public void iMakeAValidRequestById(String arg0) throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getById(arg0));
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get back a Spartan that contain the id {string}")
    public void iGetBackASpartanThatContainTheId(String arg0) {
        Assertions.assertEquals(arg0,((SpartanDTO) iResponse).getId());
    }

    @When("I make a valid request by year and month {string}")
    public void iMakeAValidRequestByYearAndMonth(String arg0) {
    }

    @Then("I get back a Json array of Spartans that joined on or after {string}")
    public void iGetBackAJsonArrayOfSpartansThatJoinedOnOrAfter(String arg0) {
    }

    @When("I make a valid request by year month and day {string}")
    public void iMakeAValidRequestByYearMonthAndDay(String arg0) {
    }

    @When("I make a valid request by year {string}")
    public void iMakeAValidRequestByYear(String arg0) {
    }

    @When("I make a valid request by a non-existing name")
    public void iMakeAValidRequestByANonExistingName() {
    }

    @When("I make valid request by an empty name")
    public void iMakeValidRequestByAnEmptyName() {
    }

    @When("I make a valid request by full name {string}")
    public void iMakeAValidRequestByFullName(String arg0) {
    }

    @Then("I get back a Json array of Spartans that contain the full name {string}")
    public void iGetBackAJsonArrayOfSpartansThatContainTheFullName(String arg0) {
    }

    @When("I make a valid request by first name {string}")
    public void iMakeAValidRequestByFirstName(String arg0) {
    }

    @Then("I get back a Json array of Spartans that contain the first name {string}")
    public void iGetBackAJsonArrayOfSpartansThatContainTheFirstName(String arg0) {
    }


    @When("I make a valid request by stream name {string}")
    public void iMakeAValidRequestByStreamName(String stream) throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByStream(stream));
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get back a JSON response containing all Spartans with that String in their stream name {string}")
    public void iGetBackAJSONResponseContainingAllSpartansWithThatStringInTheirStreamName(String stream) {
        Assertions.assertTrue(((ListOfSpartanDTO) iResponse).isSpartanInStream(stream));
    }

    @Then("I get back a JSON response containing all Spartans with that name")
    public void iGetBackAJSONResponseContainingAllSpartansWithThatName() {
        Assertions.assertEquals(204, callManager.getStatusCode()); // this is to do with the json not the status code needs changed
    }

    @When("I make a valid request by first and last name {string}")
    public void iMakeAValidRequestByFirstAndLastName(String arg0) {
    }

    @Then("I get back a Json array of Spartans that contain the first and last name {string}")
    public void iGetBackAJsonArrayOfSpartansThatContainTheFirstAndLastName(String arg0) {
    }

    @Then("The email should end with @spartaglobal.com")
    public void theEmailShouldEndWithSpartaglobalCom() {
        Assertions.assertTrue(((ListOfSpartanDTO)iResponse).getSpartans().get(0).isEmailValidFormat());
    }

}
