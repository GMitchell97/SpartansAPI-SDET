package com.sparta.spartansapi.cucumber.stepdefs;

import com.sparta.spartansapi.connection.CallManager;
import com.sparta.spartansapi.connection.ConnectionManager;
import com.sparta.spartansapi.dto.ErrorDTO;
import com.sparta.spartansapi.dto.ListOfCourseDTO;
import com.sparta.spartansapi.dto.ListOfStreamDTO;
import com.sparta.spartansapi.injector.Injector;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assumptions;

import java.io.IOException;

import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.callManager;
import static com.sparta.spartansapi.cucumber.stepdefs.UtilStepdefs.iResponse;

public class StreamCrudStepDefs {
    String id;
    
    @Given("I have a valid stream ID")
    public void iHaveAValidStreamID() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getStreams().getAddStreamUrl(), CallManager.Methods.POST,
                "{\n" +
                        "    \"name\": \"Wizarding\",\n" +
                        "    \"duration\": 12\n" +
                        "}");
        iResponse = Injector.injectDTO(callManager);
        id = ((ListOfStreamDTO) iResponse).getStreams().get(0).getId();
    }

    @When("I make a request to add a stream with correct fields")
    public void iMakeARequestToAddAStreamWithCorrectFields() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getStreams().getAddStreamUrl(), CallManager.Methods.POST,
                "{\n" +
                        "    \"name\": \"Wizarding\",\n" +
                        "    \"duration\": 12\n" +
                        "}");
        iResponse = Injector.injectDTO(callManager);
        id = ((ListOfStreamDTO) iResponse).getStreams().get(0).getId();
    }


    @When("I make a request to add a stream with incorrect fields")
    public void iMakeARequestToAddAStreamWithIncorrectFields() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getStreams().getAddStreamUrl(), CallManager.Methods.POST,
                "{\n" +
                        "    \"name\": null,\n" +
                        "    \"duration\": 12\n" +
                        "}");
        iResponse = Injector.injectDTO(callManager);
    }

    @When("I make a valid PUT request to an existing streamId")
    public void iMakeAValidPUTRequestToAnExistingStreamId() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getStreams().getStreamUpdateUrl(id), CallManager.Methods.PATCH,
                "{\n" +
                        "    \"name\": \"Wizarding666\",\n" +
                        "    \"duration\": 12\n" +
                        "}");

        iResponse = Injector.injectDTO(callManager);
    }


    @When("I make a valid PUT request to a non-existing streamId")
    public void iMakeAValidPUTRequestToANonExistingStreamId() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getStreams().getStreamUpdateUrl("notValid"), CallManager.Methods.PATCH,
                "{\n" +
                        "    \"name\": \"somethingFishy\",\n" +
                        "    \"duration\": 12\n" +
                        "}");

        iResponse = Injector.injectDTO(callManager);
    }


    @When("I make a request to remove a stream with valid ID")
    public void iMakeARequestToRemoveAStreamWithValidID() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getStreams().getStreamDeleteUrl(id), CallManager.Methods.DELETE);
        iResponse = Injector.injectDTO(callManager);
        id = null;
    }

    @When("I make a request to remove a stream with invalid ID")
    public void iMakeARequestToRemoveAStreamWithInvalidID() throws IOException, InterruptedException {
        callManager = new CallManager(ConnectionManager.getStreams().getStreamUpdateUrl("notValid"), CallManager.Methods.DELETE);
        iResponse = Injector.injectDTO(callManager);
    }

    @After
    public void teardown() throws IOException, InterruptedException {
        if (id != null) {
            CallManager callManager = new CallManager(ConnectionManager.getStreams().getStreamDeleteUrl(id), CallManager.Methods.DELETE);
            Assumptions.assumeTrue(callManager.getStatusCode() == 200);
        }
    }

}
