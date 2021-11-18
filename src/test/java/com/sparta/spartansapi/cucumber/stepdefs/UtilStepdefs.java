package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.dto.ErrorDTO;
import com.sparta.spartansapi.dto.IResponse;
import com.sparta.spartansapi.dto.ListDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class UtilStepdefs {

    public static CallManager callManager;
    public static IResponse iResponse;


    @Then("I get back an error message {string}")
    public void iGetBackAnErrorMessage(String message) {
        Assertions.assertEquals(message, ((ErrorDTO) iResponse).getMessage());
    }

    @Then("I get back a message {string}")
    public void iGetBackAMessage(String message) {
        Assertions.assertEquals(message, ((ListDTO) iResponse).getMessage());
    }

    @Given("I use a valid API key")
    public void iUseAValidAPIKey() {
    }

    @Then("I get back a {int} response code")
    public void iGetBackAResponseCode(int code) {
        Assertions.assertEquals(code, callManager.getStatusCode());
    }
}
