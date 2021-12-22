package Starter.Product;

import Starter.BaseTest.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class createProduct extends baseTest {
    @Given("I am success logged in as a user")
    public void iAmSuccessLoggedInAsAUser() {
        createProductSteps.hitEndpointLogin();
    }

    @And("I am set body request name {string} subcategory_id {string} city_id {string} price {string} description {string} stock {string} guarantee {string}")
    public void iAmSetBodyRequestNameSubcategory_idCity_idPriceDescriptionStockGuarantee(String name, String subcategory_id, String city_id, String price, String description, String stock, String guarantee) {
        createProductSteps.setBodyRequest(name, subcategory_id, city_id, price, description, stock, guarantee);
    }

    @When("I am hit endpoint create product")
    public void iAmHitEndpointCreateProduct() {
        createProductSteps.hitEnpointCreateProduct();
    }

    @Then("I am get a status code {int} create product")
    public void iAmGetAStatusCodeCreateProduct(int statuscode) {
        createProductSteps.validateEndpointCreateProduct(statuscode);
    }

    @And("validate response body code {int} and message {string}")
    public void validateResponseBodyCodeAndMessage(int code, String message) {
        createProductSteps.JsonschemaEndpointCreateProduct(code, message);
    }
}