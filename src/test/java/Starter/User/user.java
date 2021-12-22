package Starter.User;

import Starter.BaseTest.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class user extends baseTest {
    @Given("I am success get user who is currently logged in")
    public void iAmSuccessGetUserWhoIsCurrentlyLoggedIn() {
        Users.hitEndpointLogin();
    }
    @When("I am hit endpoint get user who is currently logged in")
    public void iAmHitEndpointGetUserWhoIsCurrentlyLoggedIn() {
        Users.hitEndppointGetUser();
    }
    @Then("I am get success a status code {int}")
    public void iAmGetSuccessAStatusCode(int statuscode) {
        Users.validateStatusCodeEndpoint(statuscode);
    }
    @And("validate get user response body code {int} message {string}")
    public void validateGetUserResponseBodyCodeMessage(int code, String message) {
        Users.jsonshemaEndpointGetUser(code, message);
    }
    @Given("I am update data nama {string} email {string} password {string} phone{string}")
    public void iAmUpdateDataNamaEmailPasswordPhone(String nama, String email, String password, String phone) {
        Users.setBodyRequestEdit(nama, email, password, phone);
    }
    @When("I am hit endpoint put user who is currently logged in")
    public void iAmHitEndpointPutUserWhoIsCurrentlyLoggedIn() {
        Users.hitEndpointPutUser();
    }

    @And("validate put user response body code {int} message {string}")
    public void validatePutUserResponseBodyCodeMessage(int code, String message) {
        Users.jsonschmeEndpointPutUser(code, message);
    }
    @When("I am hit endpoint delete user who is currently logged in")
    public void iAmHitEndpointDeleteUserWhoIsCurrentlyLoggedIn() {
        Users.hitEndpointDeleteUser();
    }

    @And("validate delete user response body code {int} message {string}")
    public void validateDeleteUserResponseBodyCodeMessage(int code, String message) {
        Users.jsonschmeEndpointDeleteUser(code, message);
    }
    @When("I am failed hit endpoint get user who is currently logged in")
    public void iAmFailedHitEndpointGetUserWhoIsCurrentlyLoggedIn() {
        Users.hitEndppointFailedGetUser();
    }
    @And("validate failed get user response body message {string}")
    public void validateFailedGetUserResponseBodyMessage(String message) {
        Users.jsonschmeEndpointFailedPutUser(message);
    }
    @And("validate failed put user response body message {string}")
    public void validateFailedPutUserResponseBodyMessage(String message) {
        Users.jsonschmeEndpointFailedPutUser(message);
    }

    @When("I am update data nama {string} email {string} password {string} phone{string} not token")
    public void iAmUpdateDataNamaEmailPasswordPhoneNotToken(String nama, String email, String password, String phone) {
        Users.setBodyRequestFailedEdit(nama, email, password, phone);
    }

    @When("I am failed hit endpoint delete user who is currently logged in")
    public void iAmFailedHitEndpointDeleteUserWhoIsCurrentlyLoggedIn() {
        Users.hitEndpointFailedDeleteUser();
    }

    @And("validate failed delete user response body message {string}")
    public void validateFailedDeleteUserResponseBodyMessage(String message) {
        Users.jsonschmeEndpointFailedDeleteUser(message);
    }
}