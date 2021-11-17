package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrudStepdefs {

    @When("I make a request to add a spartan with correct fields")
    public void iMakeARequestToAddASpartanWithCorrectFields() {
    }


    @When("I make a request to add a spartan with incorrect fields")
    public void iMakeARequestToAddASpartanWithIncorrectFields() {
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
