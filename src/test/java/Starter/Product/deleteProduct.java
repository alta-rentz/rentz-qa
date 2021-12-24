package Starter.Product;

import Starter.BaseTest.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class deleteProduct extends baseTest {
    @Given("I am succes logged in")
    public void iAmSuccesLoggedIn() {
        deleteProductSteps.hitEndpointLogin();
    }

    @When("I am hit endpoint delete product ID {int}")
    public void iAmHitEndpointDeleteProductID(int ID) {
        deleteProductSteps.hitEndPointdeleteProductID(ID);
    }

    @Then("I am get status code {int} for delete product")
    public void iAmGetStatusCodeForDeleteProduct(int statuscode) {
        deleteProductSteps.valdateEndpointGet(statuscode);
    }

    @And("validate response body code {int} message {string}")
    public void validateResponseBodyCodeMessage(int code, String message) {
        deleteProductSteps.JsonSchemaDeleteProduct(code, message);
    }
}