package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.SpartanDTO;
import com.sparta.spartansapi.injector.Injector;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.net.ConnectException;

import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.callManager;
import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.iResponse;

public class AllStepdefs {

    @When("I make a GET request to get all spartans")
    public void iMakeAGETRequestTo() {
        callManager = new CallManager(ConnectionManager.getSpartans().getAll());
        //iResponse = Injector.injectDTO(callManager);
    }

    @Then("receive a list of all spartans in a json format")
    public void receiveAListOfAllSpartansInAJsonFormat() {
        Assertions.assertTrue(SpartanDTO.isJSONValid(callManager.getJson()));
    }

    @When("I make a GET request to all")
    public void iMakeAGETRequestToAll() {
        callManager = new CallManager(ConnectionManager.getSpartans().getAll());
    }

    @When("I make a GET request to al")
    public void iMakeAGETRequestToAl() {
        callManager = new CallManager(ConnectionManager.getBaseURL() + "/spartan/al");
    }
}
