package Starter.Register;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class register {

    @Steps
    registerSteps RegisterSteps;

    @Given("I am on the register page")
    public void i_am_on_the_register_page() {
    }

    @When("I enter my name,email,password,phone correctly")
    public void i_enter_my_name_email_password_phone_correctly() {
        RegisterSteps.setBodyReq();
    }

    @When("I click {string} buttons")
    public void i_click_buttons(String string) {
        RegisterSteps.hitEndpointRegister();
    }

    @Then("I am taken to the Home_Page")
    public void i_am_taken_to_the_Home_Page() {
        RegisterSteps.valdateEndpointRegister();
    }

}