package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.SpartanDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class UtilStepdefs {

    public static CallManager callManager;
    public static SpartanDTO spartanDTO;

    @Then("I get an empty list")
    public void iGetAnEmptyList() {
    }

    @Then("I get back an error message")
    public void iGetBackAnErrorMessage() {
    }

    @Given("I use a valid API key")
    public void iUseAValidAPIKey() {
    }

    @Then("I get back a {int} response code")
    public void iGetBackAResponseCode(int code) {
        Assertions.assertEquals(code, callManager.getStatusCode());
    }

}
