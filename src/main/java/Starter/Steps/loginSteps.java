package Starter.Steps;

import Starter.BaseEndpoint.baseEndpoint;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class loginSteps {
    baseEndpoint endpoint = new baseEndpoint();

    JSONObject requestParams;

    //add request params
    public void setRequestParams(String email, String password){
        requestParams = new JSONObject();
        requestParams.put("email",email);
        requestParams.put("password",password);
    }

    //Set Header and BodyRequest
    public void setHeader(String header, String content){
        SerenityRest
                .given()
                .header(header,content)
                .body(requestParams.toString());
    }

    //Set Endpoint
    public void hitEndpointLogin(){
        SerenityRest
                .when()
                .post(endpoint.LOGIN);
    }

    //Validasi Status Code Response
    public void validateEndpointLogin(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //Validasi JSONSchema Login Sukses
    public void JsonSchemaEndpointLoginSukses(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JsonSchema/Login/loginSukses.json"));
    }
    //Validasi JSONSchema Login Failed
    public void JsonShemaEndpointLoginFailed(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Login/loginFailed.json"));
    }
}
