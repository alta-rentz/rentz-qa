package Starter.Checkout;

import Starter.BaseTest.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkoutBooking extends baseTest {
    @Given("I am logged in user")
    public void iAmLoggedInUser() {
        checkoutSteps.hitEndpointLogin();
    }

    @When("I am set body request checkout with ovo")
    public void iAmSetBodyRequestCheckoutWithOvo() {
        checkoutSteps.setBodyRequestOVO();
    }

    @Then("I am get statuscode {int}")
    public void iAmGetStatuscode(int statuscode) {
        checkoutSteps.validateEndpointCheckout(statuscode);
    }

    @And("validate checkout with ovo response body code {int} message {string}")
    public void validateCheckoutWithOvoResponseBodyCodeMessage(int code, String message) {
        checkoutSteps.JsonschemaEndpointCheckoutOvo(code, message);
    }

    @When("I am set body request checkout other than ovo")
    public void iAmSetBodyRequestCheckoutOtherThanOvo() {
        checkoutSteps.setBodyRequestOtherThanOVO();
    }

    @And("validate checkout with other than ovo response body code {int} message {string}")
    public void validateCheckoutWithOtherThanOvoResponseBodyCodeMessage(int code, String message) {
        checkoutSteps.JsonschemaEndpointCheckoutOtherOvo(code, message);
    }
}