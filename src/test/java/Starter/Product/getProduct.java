package Starter.Product;

import Starter.BaseTest.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class getProduct extends baseTest {
    @Given("I am set header {string} with fill {string}")
    public void iAmSetHeaderWithFill(String header, String content) {
        getProdSteps.setHeader(header, content);
    }

    @When("I am hit endpoint get all products")
    public void iAmHitEndpointGetAllProducts() {
        getProdSteps.hitEndPointGetProduct();
    }

    @Then("I am get status code {int} for get all products")
    public void iAmGetStatusCodeForGetAllProducts(int statuscode) {
        getProdSteps.valdateEndpointGet(statuscode);
    }

    @And("validate success response body code {int} message {string}")
    public void validateSuccessResponseBodyCodeMessage(int code, String message) {
        getProdSteps.JsonSchemaGetAllProductSuccess(code, message);
    }

    @When("I am hit endpoint get subcategory by SubcategoryID {int}")
    public void iAmHitEndpointGetSubcategoryBySubcategoryID(int SubcategoryID) {
        getProdSteps.hitEndPointGetProductSID(SubcategoryID);
    }

    @Then("I am get status code {int} for get product by SubcategoryID")
    public void iAmGetStatusCodeForGetProductBySubcategoryID(int statuscode) {
        getProdSteps.valdateEndpointGet(statuscode);
    }

    @And("validate success response body code {int} message {string} for get product by SubcategoryID {int}")
    public void validateSuccessResponseBodyCodeMessageForGetProductBySubcategoryID(int code, String message, int SubcategoryID) {
        getProdSteps.JsonSchemaGetProductBySID(code, message, SubcategoryID);
    }

    @When("I am hit endpoint get product by ID {int}")
    public void iAmHitEndpointGetProductByID(int ID) {
        getProdSteps.hitEndPointGetProductID(ID);
    }

    @Then("I am get status code {int} for get product by ID")
    public void iAmGetStatusCodeForGetProductByID(int statuscode) {
        getProdSteps.valdateEndpointGet(statuscode);
    }

    @And("validate success response body code {int} message {string} for get product by ID {int}")
    public void validateSuccessResponseBodyCodeMessageForGetProductByID(int code, String message, int ID) {
        getProdSteps.JsonSchemaGetProductByID(code, message, ID);
    }
}
