package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.ListOfSpartanDTO;
import com.sparta.spartansapi.dto.SpartanDTO;
import com.sparta.spartansapi.injector.Injector;
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

    @When("I make a valid request by id {string}")
    public void iMakeAValidRequestById(String arg0) throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getById(arg0));
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get back a Spartan that contain the id {string}")
    public void iGetBackASpartanThatContainTheId(String arg0) {
        Assertions.assertEquals(arg0,((ListOfSpartanDTO) iResponse).getSpartans().get(0).getId());
    }

    @When("I make a valid request by a non-existing name")
    public void iMakeAValidRequestByANonExistingName() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByName("Gustavo"));
        iResponse = Injector.injectDTO(callManager);
    }

    @When("I make valid request by an empty name")
    public void iMakeValidRequestByAnEmptyName() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByName(""));
        iResponse = Injector.injectDTO(callManager);
    }

    @When("I make a valid request by full name {string}")
    public void iMakeAValidRequestByFullName(String arg0) throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByName(arg0));
        iResponse = Injector.injectDTO(callManager);
    }

    //test should fail.
    @Then("I get back a Json array of Spartans that contain the full name {string}")
    public void iGetBackAJsonArrayOfSpartansThatContainTheFullName(String arg0) {
        Assertions.assertTrue(((ListOfSpartanDTO) iResponse).isSpartanNameInResponse(arg0));
    }

    @When("I make a valid request by first name {string}")
    public void iMakeAValidRequestByFirstName(String arg0) throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByName(arg0));
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get back a Json array of Spartans that contain the first name {string}")
    public void iGetBackAJsonArrayOfSpartansThatContainTheFirstName(String arg0){
        Assertions.assertTrue(((ListOfSpartanDTO) iResponse).isSpartanFirstNameInResponse(arg0));
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

    @When("I make a valid request by first and last name {string}")
    public void iMakeAValidRequestByFirstAndLastName(String arg0) throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getByName(arg0));
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("I get back a Json array of Spartans that contain the first and last name {string}")
    public void iGetBackAJsonArrayOfSpartansThatContainTheFirstAndLastName(String arg0) {
        Assertions.assertTrue(((ListOfSpartanDTO) iResponse).isSpartanNameInResponse(arg0));
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
        Assertions.assertEquals(expected.toString(), ((ListOfSpartanDTO) iResponse).getSpartans().toString()); // response contains actual value
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
        Assertions.assertEquals(expected.toString(), ((ListOfSpartanDTO) iResponse).getSpartans().toString()); // response contains actual value
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
        Assertions.assertEquals(expected.toString(), ((ListOfSpartanDTO) iResponse).getSpartans().toString()); // response contains actual value
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
        Assertions.assertEquals(expected.toString(), ((ListOfSpartanDTO) iResponse).getSpartans().toString()); // response contains actual value
    }

    @When("I search for Spartans who end their contract on an invalid full date")
    public void iSearchForSpartansWhoEndTheirContractOnAnInvalidFullDate() throws IOException, InterruptedException {
        // TODO: implement other paramaters for invalid end date (format, before sparta founding, before the start date, etc.)
        callManager = new CallManager(ConnectionManager.getSpartans().getByEndDate("invalid-start-date"));
        iResponse = Injector.injectDTO(callManager);
    }
  
    @Then("The email should have the correct name end with @spartaglobal.com")
    public void theEmailShouldHaveTheCorrectNameEndWithSpartaglobalCom() {
        Assertions.assertTrue(((ListOfSpartanDTO)iResponse).getSpartans().get(0).isEmailValidFormat());
    }

    @When("I check a spartans id")
    public void iCheckASpartansId() {
    }

    @Then("id is not null")
    public void idIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isIdNull());
    }

    @When("I check a spartans firstName")
    public void iCheckASpartansFirstName() {
    }

    @Then("firstName is not null")
    public void firstnameIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isFirstNameNull());
    }

    @When("I check a spartans lastName")
    public void iCheckASpartansLastName() {
    }

    @Then("lastName is not null")
    public void lastnameIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isLastNameNull());
    }

    @When("I check a spartans startDate")
    public void iCheckASpartansStartDate() {
    }

    @Then("startDate is not null")
    public void startdateIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isStartDateNull());
    }

    @When("I check a spartans course")
    public void iCheckASpartansCourse() {
    }

    @Then("course is not null")
    public void courseIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isCourseNull());
    }

    @When("I check a spartans course name")
    public void iCheckASpartansCourseName() {
    }

    @Then("course name is not null")
    public void courseNameIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isCourseNameNull());
    }

    @When("I check a spartans stream")
    public void iCheckASpartansStream() {
    }

    @Then("stream is not null")
    public void streamIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isStreamNull());
    }

    @When("I check a spartans stream duration")
    public void iCheckASpartansStreamDuration() {
    }

    @Then("stream duration is not null")
    public void streamDurationIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isStreamDurationNull());
    }

    @When("I check a spartans stream name")
    public void iCheckASpartansStreamName() {
    }

    @Then("stream name is not null")
    public void streamNameIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isStreamNameNull());
    }

    @When("I check a spartans email")
    public void iCheckASpartansEmail() {
    }

    @Then("email is not null")
    public void emailIsNotNull() {
        Assertions.assertFalse(((ListOfSpartanDTO) iResponse).isEmailNull());
    }

}
