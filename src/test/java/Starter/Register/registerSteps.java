package Starter.Register;

import Starter.utils.Endpoint;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class registerSteps {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParams;

    @Step
    public void setBodyReq() {
        requestParams = new JSONObject();
        requestParams.put("nama","Hassimi Smilikitty");
        requestParams.put("email", "smilikitty121@alterra.id");
        requestParams.put("password", "smile123121");
        requestParams.put("phone","08121219311021");
    }

    @Step
    public void hitEndpointRegister() {
        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post(endpoint.REGISTER)
                .then()
                .statusCode(200);
    }

    @Step
    public void valdateEndpointRegister() {
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/register.json"));
    }
}
