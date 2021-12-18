package Starter.Pages;

import Starter.BaseTest.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login extends baseTest {
    @Given("I am set body request email {string} and password {string}")
    public void iAmSetBodyRequestEmailAndPassword(String email, String password) {
        logSteps.setRequestParams(email, password);
    }
    @And("I am set valid header {string} with fill {string}")
    public void iAmSetValidHeaderWithFill(String header, String content) {
        logSteps.setHeader(header, content);
    }

    @When("I am hit endpoint login")
    public void iAmHitEndpointLogin() {
        logSteps.hitEndpointLogin();
    }

    @Then("I am get a status code {int}")
    public void iAmGetAStatusCode(int statuscode) {
        logSteps.validateEndpointLogin(statuscode);
    }

    @And("valid response success")
    public void validResponseSuccess() {
        logSteps.JsonSchemaEndpointLoginSukses();
    }

    @And("Validate failed response body {int} and message {string}")
    public void validateFailedResponseBodyAndMessage(int statuscode, String message) {
        logSteps.JsonShemaEndpointLoginFailed(statuscode, message);
    }
}