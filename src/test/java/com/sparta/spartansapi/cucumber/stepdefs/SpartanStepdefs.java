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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Then("I get back an empty list")
    public void iGetBackAnEmptyList() {
    }

    @When("I make a valid request by id {string}")
    public void iMakeAValidRequestById(String arg0) throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getById(arg0));
        iResponse = Injector.injectDTO(callManager);
    }

    @And("That id is in the database")
    public void thatIdIsInTheDatabase() {
    }

    @Then("I get back a Spartan that contain the id {string}")
    public void iGetBackASpartanThatContainTheId(String arg0) {
    }

    @And("that id isnt in the database")
    public void thatIdIsntInTheDatabase() {
    }

    @Then("I Should get back an empty json array")
    public void iShouldGetBackAnEmptyJsonArray() {
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
    public void iMakeAValidRequestByStreamName(String streamName) throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByStream(streamName));
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get back a JSON response containing all Spartans with that String in their streamname")
    public void iGetBackAJSONResponseContainingAllSpartansWithThatStringInTheirStreamname() {
        Assertions.assertTrue(((ListOfSpartanDTO) iResponse).isSpartanInStream("Java"));
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

    @When("I make a valid request by last name {string}")
    public void iMakeAValidRequestByLastName(String arg0) {
    }

    @When("I search for Spartans who start their contract on a specified full date")
    public void iSearchForSpartansWhoStartTheirContractOnASpecifiedFullDate() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByStartDate("2022-09-04")); // TODO: implement parameterised tests
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get a list of Spartans who start their contract on the specified full date")
    public void iGetAListOfSpartansWhoStartTheirContractOnTheSpecifiedFullDate() throws IOException, InterruptedException {
        LocalDate date = LocalDate.parse("2022-09-04"); // TODO: implement parameterised tests
        CallManager m = new CallManager(ConnectionManager.getSpartans().getAll()); // get all spartans
        List<SpartanDTO> expected = ((ListOfSpartanDTO) Injector.injectDTO(m)).getSpartansByStartDate(date);
        Assertions.assertEquals(expected, ((ListOfSpartanDTO) iResponse).getSpartans()); // response contains actual value
    }

    @When("I search for Spartans who start their contract who start their contract within a specified date range")
    public void iSearchForSpartansWhoStartTheirContractWhoStartTheirContractWithinASpecifiedDateRange() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByStartDateInRange("2022-09-03", "2022-09-05")); // TODO: implement parameterised tests
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get a list of Spartans who start their contract within the specified date range")
    public void iGetAListOfSpartansWhoStartTheirContractWithinTheSpecifiedDateRange() throws IOException, InterruptedException {
        List<LocalDate> range = Arrays.asList(LocalDate.parse("2022-09-03"), LocalDate.parse("2022-09-05")); // TODO: implement parameterised tests
        CallManager m = new CallManager(ConnectionManager.getSpartans().getAll()); // get all spartans
        List<SpartanDTO> expected = ((ListOfSpartanDTO) Injector.injectDTO(m)).getSpartansByStartDateInRange(range.get(0), range.get(1));
        Assertions.assertEquals(expected, ((ListOfSpartanDTO) iResponse).getSpartans()); // response contains actual value
    }

    @When("I search for Spartans who start their contract on an invalid full date")
    public void iSearchForSpartansWhoStartTheirContractOnAnInvalidFullDate() throws IOException, InterruptedException {
        // TODO: implemented other paramaters for invalid start date (format, before sparta founding, after the end date, etc.)
        callManager = new CallManager(ConnectionManager.getSpartans().getByStartDate("invalid-start-date"));
        iResponse = Injector.injectDTO(callManager);
    }

    @When("I search for Spartans who end their contract on a specified full date")
    public void iSearchForSpartansWhoEndTheirContractOnASpecifiedFullDate() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByEndDate("2022-09-04")); // TODO: implement parameterised tests
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get a list of Spartans who end their contract within the specified date range")
    public void iGetAListOfSpartansWhoEndTheirContractWithinTheSpecifiedDateRange() throws IOException, InterruptedException {
        LocalDate date = LocalDate.parse("2022-09-04"); // TODO: implement parameterised tests
        CallManager m = new CallManager(ConnectionManager.getSpartans().getAll()); // get all spartans
        List<SpartanDTO> expected = ((ListOfSpartanDTO) Injector.injectDTO(m)).getSpartansByEndDate(date);
        Assertions.assertEquals(expected, ((ListOfSpartanDTO) iResponse).getSpartans()); // response contains actual value
    }

    @When("I search for Spartans who end their contract who end their contract within a specified date range")
    public void iSearchForSpartansWhoEndTheirContractWhoEndTheirContractWithinASpecifiedDateRange() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByEndDateInRange("2022-10-22", "2022-10-24")); // TODO: implement parameterised tests
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get a list of Spartans who end their contract on the specified full date")
    public void iGetAListOfSpartansWhoEndTheirContractOnTheSpecifiedFullDate() throws IOException, InterruptedException {
        List<LocalDate> range = Arrays.asList(LocalDate.parse("2022-10-22"), LocalDate.parse("2022-10-24")); // TODO: implement parameterised tests
        CallManager m = new CallManager(ConnectionManager.getSpartans().getAll()); // get all spartans
        List<SpartanDTO> expected = ((ListOfSpartanDTO) Injector.injectDTO(m)).getSpartansByEndDateInRange(range.get(0), range.get(1));
        Assertions.assertEquals(expected, ((ListOfSpartanDTO) iResponse).getSpartans()); // response contains actual value
    }

    @When("I search for Spartans who end their contract on an invalid full date")
    public void iSearchForSpartansWhoEndTheirContractOnAnInvalidFullDate() throws IOException, InterruptedException {
        // TODO: implemented other paramaters for invalid end date (format, before sparta founding, before the start date, etc.)
        callManager = new CallManager(ConnectionManager.getSpartans().getByEndDate("invalid-start-date"));
        iResponse = Injector.injectDTO(callManager);
    }
}
