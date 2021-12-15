package Starter.Pages;

import Starter.BaseTest.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class register extends baseTest {
    @Given("I am set body request for register name {string} email {string} password {string} phone {string}")
    public void iAmSetBodyRequestForRegisterNameEmailPasswordPhone(String nama, String email, String password, String phone) {
        regSteps.setRequestBody(nama, email, password, phone);
    }

    @And("I am set header for register {string} with fill {string}")
    public void iAmSetHeaderForRegisterWithFill(String header, String content) {
        regSteps.setHeader(header, content);
    }

    @When("I am hit endpoint register")
    public void iAmHitEndpointRegister() {
        regSteps.hitEndpointRegister();
    }

    @Then("I am get status code {int}")
    public void iAmGetStatusCode(int statuscode) {
        regSteps.valdateEndpointRegister(statuscode);
    }

    @And("valid response success register")
    public void validResponseSuccessRegister() {
    }

    @And("validate error message nama tidak boleh kosong")
    public void validateErrorMessageNamaTidakBolehKosong() {
    }

    @And("validate error message Email or Phone Number is Exist")
    public void validateErrorMessageEmailOrPhoneNumberIsExist() {

    }

    @And("validate error message Email must contain email format")
    public void validateErrorMessageEmailMustContainEmailFormat() {


    }

    @And("validate error message password cannot less than {int} character")
    public void validateErrorMessagePasswordCannotLessThanCharacter(int arg0) {

    }

    @And("validate error message password cannot be empty")
    public void validateErrorMessagePasswordCannotBeEmpty() {
    }

    @And("validate error message Phone Number cannot be empty")
    public void validateErrorMessagePhoneNumberCannotBeEmpty() {
    }
}
