package Starter.Booking;

import Starter.BaseTest.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bookingProduct extends baseTest {
    @Given("I am logged in as user")
    public void iAmLoggedInAsUser() {
        bookingSteps.hitEndpointLogin();
    }

    @And("I am set body request create booking")
    public void iAmSetBodyRequestCreateBooking() {
        bookingSteps.setBodyRequestCreate();
    }

    @When("I am hit endpoint create booking method post")
    public void iAmHitEndpointCreateBookingMethodPost() {
        bookingSteps.hitEndpointCreateBooking();
    }

    @Then("I get status code {int}")
    public void iGetStatusCode(int statuscode) {
        bookingSteps.validateEndpointBooking(statuscode);
    }

    @And("validate success create booking response message {string} status {string}")
    public void validateSuccessCreateBookingResponseMessageStatus(String message, String status) {
        bookingSteps.JsonschemaEndpointSuccessBooking(message, status);
    }

    @And("I am set body request create booking from personal rental booking")
    public void iAmSetBodyRequestCreateBookingFromPersonalRentalBooking() {
        bookingSteps.setBodyRequestPersonalRental();
    }

    @And("validate failed create booking response body code {int} message {string}")
    public void validateFailedCreateBookingResponseBodyCodeMessage(int code, String message) {
        bookingSteps.JsonschemaEndpointBooking(code, message);
    }

    @And("I am set body request at the same request time_in and time_out")
    public void iAmSetBodyRequestAtTheSameRequestTime_inAndTime_out() {
        bookingSteps.setBodyRequestSameTime();
    }

    @And("I am set body request time_in {string} time_out {string}")
    public void iAmSetBodyRequestTime_inTime_out(String time_in, String time_out) {
        bookingSteps.setBodyRequestSearchBooking(time_in, time_out);
    }

    @When("I am hit endpoint search booking method post by ID_Booking")
    public void iAmHitEndpointSearchBookingMethodPostByID_Booking(int ID) {
        bookingSteps.hitEndpointSearchBooking(ID);
    }

    @And("validate success search booking code {int} message {string}")
    public void validateSuccessSearchBookingCodeMessage(int code, String message) {
        bookingSteps.JsonschemaEndpointBooking(code, message);
    }

    @When("I am hit endpoint get booking method get by ID_Booking")
    public void iAmHitEndpointGetBookingMethodGetByID_Booking(int ID) {
        bookingSteps.hitEndpointGetBooking(ID);
    }

    @And("validate success get booking code {int} message {string}")
    public void validateSuccessGetBookingCodeMessage(int code, String message) {
        bookingSteps.JsonschemaEndpointGetBooking(code, message);
    }

    @When("I am hit endpoint cancel booking method delete by ID_Booking")
    public void iAmHitEndpointCancelBookingMethodDeleteByID_Booking(int ID) {
        bookingSteps.hitEndpointDeleteBooking(ID);
    }

    @And("validate success delete booking code {int} message {string}")
    public void validateSuccessDeleteBookingCodeMessage(int code, String message) {
        bookingSteps.JsonschemaEndpointBooking(code, message);
    }
}