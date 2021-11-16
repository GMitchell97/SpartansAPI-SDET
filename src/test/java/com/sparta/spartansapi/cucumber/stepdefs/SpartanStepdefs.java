package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.ErrorDTO;
import com.sparta.spartansapi.dto.ListOfSpartanDTO;
import com.sparta.spartansapi.injector.Injector;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.*;

public class SpartanStepdefs {


    @When("I make a valid request by course name {string}")
    public void iMakeAValidRequestByCourseName(String arg0) {
    }

    @Then("I get back a list of Spartans that contain the course name {string}")
    public void iGetBackAListOfSpartansThatContainTheCourseName(String arg0) {
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

    @Then("I get back an empty list")
    public void iGetBackAnEmptyList() {
    }

    @When("I make a valid request by id {string}")
    public void iMakeAValidRequestById(String arg0) {
    }

    @And("That id is in the database")
    public void thatIdIsInTheDatabase() {
    }

    @Then("I get back a  Spartan that contain the id {string}")
    public void iGetBackASpartanThatContainTheId(String arg0) {
    }

    @And("that id isnt in the database")
    public void thatIdIsntInTheDatabase() {
    }

    @Then("I Should get back an empty json array")
    public void iShouldGetBackAnEmptyJsonArray() {
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

    @When("I make a valid request by last name {string}")
    public void iMakeAValidRequestByLastName(String lName) {

    }

    @Then("I get back a Json array of Spartans that contain the last name {string}")
    public void iGetBackAJsonArrayOfSpartansThatContainTheLastName(String arg0) {
    }

    @When("I make a valid request by stream name {string}")
    public void iMakeAValidRequestByStreamName(String streamName) {
        callManager = new CallManager(ConnectionManager.getSpartan().getByStream(streamName));
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get back a JSON response containing all Spartans with that String in their streamname")
    public void iGetBackAJSONResponseContainingAllSpartansWithThatStringInTheirStreamname() {
        Assertions.assertTrue(((ListOfSpartanDTO) iResponse).isSpartanInStream("Java"));
    }

    @Then("I get back a JSON response containing all Spartans with that name")
    public void iGetBackAJSONResponseContainingAllSpartansWithThatName() {
        Assertions.assertEquals(204, callManager.getStatusCode());
    }
}
