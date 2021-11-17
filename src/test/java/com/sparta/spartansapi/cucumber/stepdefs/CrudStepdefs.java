package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.SpartanDTO;
import com.sparta.spartansapi.injector.Injector;
import io.cucumber.java.After;
import io.cucumber.java.ca.Cal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;

import java.io.IOException;

import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.*;

public class CrudStepdefs {

    private String id;


    @Given("I have a valid spartan ID")
    public void iHaveAValidSpartanID() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getAddSpartanUrl(), CallManager.Methods.POST,
                "    {\n" +
                        "        \"firstName\": \"FName\",\n" +
                        "        \"middleName\": null,\n" +
                        "        \"lastName\": \"LName\",\n" +
                        "        \"startDate\": \"2021-09-04T23:00:00.000+00:00\",\n" +
                        "        \"endDate\": \"2021-11-14T00:00:00.000+00:00\",\n" +
                        "        \"course\": \"Engineering 95\",\n" +
                        "        \"stream\": \"Java SDET\",\n" +
                        "        \"email\": \"Name@spartaglobal.com\"\n" +
                        "    }");
        iResponse = Injector.injectDTO(callManager);
        id = ((SpartanDTO) iResponse).getId();
    }

    @When("I make a request to add a spartan with correct fields")
    public void iMakeARequestToAddASpartanWithCorrectFields() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getAddSpartanUrl(), CallManager.Methods.POST,
                "    {\n" +
                        "        \"firstName\": \"FName\",\n" +
                        "        \"middleName\": null,\n" +
                        "        \"lastName\": \"LName\",\n" +
                        "        \"startDate\": \"2021-09-04T23:00:00.000+00:00\",\n" +
                        "        \"endDate\": \"2021-11-14T00:00:00.000+00:00\",\n" +
                        "        \"course\": \"Engineering 95\",\n" +
                        "        \"stream\": \"Java SDET\",\n" +
                        "        \"email\": \"Name@spartaglobal.com\"\n" +
                        "    }");
        iResponse = Injector.injectDTO(callManager);
        id = ((SpartanDTO) iResponse).getId();
    }

    @When("I make a request to add a spartan with incorrect fields")
    public void iMakeARequestToAddASpartanWithIncorrectFields() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getAddSpartanUrl(), CallManager.Methods.POST,
                "    {\n" +
                        "        \"firstName\": null,\n" +
                        "        \"middleName\": null,\n" +
                        "        \"lastName\": null,\n" +
                        "        \"startDate\": null,\n" +
                        "        \"endDate\": null,\n" +
                        "        \"course\": null,\n" +
                        "        \"stream\":null,\n" +
                        "        \"email\": null,\n" +
                        "    }");

        iResponse = Injector.injectDTO(callManager);
    }


    @When("I make a valid POST request to an existing Id")
    public void iMakeAValidPOSTRequestToAnExistingId() throws IOException, InterruptedException{
        callManager = new CallManager(ConnectionManager.getSpartans().getUpdateSpartanUrl(id), CallManager.Methods.PATCH,
                "    {\n" +
                        "        \"firstName\": \"FName\",\n" +
                        "        \"middleName\": null,\n" +
                        "        \"lastName\": \"LName\",\n" +
                        "        \"startDate\": \"2021-09-04T23:00:00.000+00:00\",\n" +
                        "        \"endDate\": \"2021-11-14T00:00:00.000+00:00\",\n" +
                        "        \"course\": \"Engineering 96\",\n" +
                        "        \"stream\": \"Java SDET\",\n" +
                        "        \"email\": \"Name@spartaglobal.com\"\n" +
                        "    }");
        iResponse = Injector.injectDTO(callManager);
    }

    @Then("the spartan should be updated")
    public void theSpartanShouldBeUpdated() throws IOException, InterruptedException {
        Assertions.assertEquals("Engineering 96",((SpartanDTO)iResponse).getCourse());
    }



    @When("I make a valid POST request to a non-existing Id")
    public void iMakeAValidPOSTRequestToANonExistingId() {
    }


    @When("I make a request to remove a spartan with ID {string}")
    public void iMakeARequestToRemoveASpartanWithID(String arg0) {
    }


    @Then("I get back a message that {string} has been added")
    public void iGetBackAMessageThatHasBeenAdded(String arg0) {
    }

    @Then("I get back a message that the entry is invalid")
    public void iGetBackAMessageThatTheEntryIsInvalid() {
    }

    @Then("I get back a message that the spartan has been updated")
    public void iGetBackAMessageThatTheSpartanHasBeenUpdated() {
    }


    @Then("I get back a message that {string} has been deleted")
    public void iGetBackAMessageThatHasBeenDeleted(String arg0) {
    }

    @Then("I get back the new spartan")
    public void iGetBackTheNewSpartan() {
        Assertions.assertEquals(id, ((SpartanDTO) iResponse).getId());
    }

    @After
    public void teardown() throws IOException, InterruptedException {
        if (id != null) {
            CallManager callManager = new CallManager(ConnectionManager.getSpartans().getDeleteSpartanUrl(id));
            Assumptions.assumeTrue(callManager.getStatusCode() == 200);
        }
    }
}
