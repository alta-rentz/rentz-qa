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
    @When("I am set body failed without booking_id request checkout with ovo")
    public void iAmSetBodyFailedWithoutBooking_idRequestCheckoutWithOvo() {
        checkoutSteps.setBodyRequestOVOFailed_1();
    }
    @When("I am set body failed without phone request checkout with ovo")
    public void iAmSetBodyFailedWithoutPhoneRequestCheckoutWithOvo() {
        checkoutSteps.setBodyRequestOVOFailed_2();
    }
    @When("I am set body request checkout other than ovo")
    public void iAmSetBodyRequestCheckoutOtherThanOvo() {
        checkoutSteps.setBodyRequestOtherThanOVO();
    }
    @And("validate checkout with other than ovo response body code {int} message {string}")
    public void validateCheckoutWithOtherThanOvoResponseBodyCodeMessage(int code, String message) {
        checkoutSteps.JsonschemaEndpointCheckoutOtherOvo(code, message);
    }
    @When("I am set body request checkout other than ovo without booking_id")
    public void iAmSetBodyRequestCheckoutOtherThanOvoWithoutBooking_id() {
        checkoutSteps.setBodyRequestOtherOVOFailed_1();
    }
    @When("I am set body request checkout other than ovo without checkout_method")
    public void iAmSetBodyRequestCheckoutOtherThanOvoWithoutCheckout_method() {
        checkoutSteps.setBodyRequestOtherOVOFailed_2();
    }
    @And("validate checkout failed response body message {string} status {string}")
    public void validateCheckoutFailedResponseBodyMessageStatus(String message, String status) {
        checkoutSteps.JsonschemaEndpointCheckoutFailed(message, status);
    }
    @And("validate checkout with failed response body code {int} message {string}")
    public void validateCheckoutWithFailedResponseBodyCodeMessage(int code, String message) {
        checkoutSteps.JsonschemaEndpointCheckoutFailed_1(code, message);
    }
}