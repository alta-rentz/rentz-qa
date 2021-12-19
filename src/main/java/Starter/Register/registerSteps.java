package Starter.Register;

import Starter.BaseEndpoint.baseEndpoint;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class registerSteps {
    baseEndpoint endpoint = new baseEndpoint();
    JSONObject requestparams;

    //add request params
    public void setRequestBody(String nama, String email, String password, String phone) {
        requestparams = new JSONObject();
        requestparams.put("nama", nama);
        requestparams.put("email", email);
        requestparams.put("password", password);
        requestparams.put("phone", phone);
    }

    //Set Header dan BodyRequest
    public void setHeader(String header, String content) {
        SerenityRest
                .given()
                .header(header, content)
                .body(requestparams.toString());
    }

    //Set Endpoint
    public void hitEndpointRegister() {
        SerenityRest
                .when()
                .post(endpoint.REGISTER);
    }

    //Validasi
    public void valdateEndpointRegister(int statuscode) {
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //Validasi JSONSchema Register
    public void JsonSchemaEndpointRegisterSukses() {
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JsonSchema/Daftar/registerSukses.json"))
                .body("message",equalTo("Successful Operation"));
    }

    public void JsonSchemaEndpointRegisterFailed(String message) {
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JsonSchema/Daftar/registerFailed.json"))
                .body("message",equalTo(message));
    }
}