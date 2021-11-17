package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.IResponse;
import com.sparta.spartansapi.injector.Injector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.*;

public class CrudStepdefs {

    @When("I make a request to add a spartan with correct fields")
    public void iMakeARequestToAddASpartanWithCorrectFields() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getSpartans().getAddSpartanUrl(), CallManager.Methods.POST,
                "{\n" +
                        "        \"firstName\": \"TestFName\",\n" +
                        "        \"middleName\": null,\n" +
                        "        \"lastName\": \"TestLName\",\n" +
                        "        \"startDate\": \"2021-09-04T23:00:00.000+00:00\",\n" +
                        "        \"endDate\": \"2021-11-14T00:00:00.000+00:00\",\n" +
                        "        \"course\": \"Engineering 95\",\n" +
                        "        \"stream\": \"Java Dev\",\n" +
                        "        \"email\": \"Temail@spartaglobal.com\"\n" +
                        "    }");
        iResponse = Injector.injectDTO(callManager);
    }


    @When("I make a request to add a spartan with incorrect fields")
    public void iMakeARequestToAddASpartanWithIncorrectFields() throws IOException, InterruptedException{
        callManager = new CallManager(ConnectionManager.getSpartans().getAddSpartanUrl(), CallManager.Methods.POST,
                "{\n" +
                        "        \"firstName\": null,\n" +
                        "        \"middleName\": null,\n" +
                        "        \"lastName\": null,\n" +
                        "        \"startDate\":null,\n" +
                        "        \"endDate\": null,\n" +
                        "        \"course\": null,\n" +
                        "        \"stream\": null,\n" +
                        "        \"email\": null,\n" +
                        "    }");
        iResponse = Injector.injectDTO(callManager);
    }


    @When("I make a valid POST request to an existing Id")
    public void iMakeAValidPOSTRequestToAnExistingId() {

    }

    @Then("the spartan should be updated")
    public void theSpartanShouldBeUpdated() {
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
}
