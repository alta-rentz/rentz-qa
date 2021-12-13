package Starter.Account;

import Starter.utils.Endpoint;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class loginSteps {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParams;

    @Step
    public void setBodyReq() {
        requestParams = new JSONObject();
        requestParams.put("email", "smilikitty121@alterra.id");
        requestParams.put("password", "smile123121");
    }

    @Step
    public void hitEndpointLogin() {
        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post(endpoint.LOGIN)
                .then()
                .statusCode(200);
    }

    @Step
    public void valdateEndpointLogin() {
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/login.json"));
    }
}