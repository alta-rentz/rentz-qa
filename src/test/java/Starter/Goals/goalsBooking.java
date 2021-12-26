package Starter.Goals;

import Starter.BaseTest.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class goalsBooking extends baseTest {
    @Given("I am logged as user rental")
    public void iAmLoggedAsUserRental() {
        goalsSteps.hitEndpointLoginUserRental();
    }

    @And("Or I am logged as user booking")
    public void orIAmLoggedAsUserBooking() {
        goalsSteps.hitEndpointLoginUserBooking();
    }

    @When("I am set body request create product as user rental")
    public void iAmSetBodyRequestCreateProductAsUserRental() {
        goalsSteps.setBodyRequestCreateProductUserProduct();
    }

    @And("I am set body request booking product as user booking")
    public void iAmSetBodyRequestBookingProductAsUserBooking() {
        goalsSteps.setBodyRequestCreateBookingUserBooking();
    }

    @And("I am set body request checkout booking with ovo")
    public void iAmSetBodyRequestCheckoutBookingWithOvo() {
        goalsSteps.setBodyRequestOVO();
    }

    @Then("I am get statucscode {int} goals mvp")
    public void iAmGetStatucscodeGoalsMvp(int statuscode) {
        goalsSteps.validateEndpointCheckout(statuscode);
    }

    @And("validate success checkout with ovo response code {int} and message {string}")
    public void validateSuccessCheckoutWithOvoResponseCodeAndMessage(int code, String message) {
        goalsSteps.JsonschemaEndpointCheckoutOvo(code, message);
    }

    @And("I am set body request checkout booking with other ovo")
    public void iAmSetBodyRequestCheckoutBookingWithOtherOvo() {
        goalsSteps.setBodyRequestOtherOVO();
    }

    @And("validate success checkout with other ovo response code {int} and message {string}")
    public void validateSuccessCheckoutWithOtherOvoResponseCodeAndMessage(int code, String message) {
        goalsSteps.JsonschemaEndpointCheckoutOtherOvo(code, message);
    }
}