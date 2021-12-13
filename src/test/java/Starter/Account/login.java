package Starter.Account;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class login {
    @Steps
    loginSteps LoginSteps;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
    }

    @When("I enter my email and password correctly")
    public void i_enter_my_email_and_password_correctly() {
        LoginSteps.setBodyReq();
    }

    @When("I click {string} button")
    public void i_click_button(String string) {
        LoginSteps.hitEndpointLogin();
    }

    @Then("I am taken to the HomePage")
    public void i_am_taken_to_the_HomePage() {
        LoginSteps.valdateEndpointLogin();
    }
}