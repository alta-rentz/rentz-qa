package Starter.Users;

import Starter.BaseEndpoint.baseEndpoint;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class users {
    baseEndpoint endpoint = new baseEndpoint();

    JSONObject requestparams;
    String token;

    //hit endpoint untuk login sebagai user
    public void hitEndpointLogin(){
        requestparams = new JSONObject();
        requestparams.put("email","olla_ramlanen@gmail.com");
        requestparams.put("password","P@ssw0rd");
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestparams.toString())
                .when()
                .post(endpoint.LOGIN)
                .then()
                .statusCode(200);

        token = SerenityRest
                .then()
                .extract()
                .path("data.Token");
    }

    //setBodyRequest untuk edit data user who currently logged in
    public void setBodyRequestEdit(String nama, String email, String password, String phone) {
        requestparams = new JSONObject();
        requestparams.put("nama", nama);
        requestparams.put("email", email);
        requestparams.put("password", password);
        requestparams.put("phone", phone);

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer "+token)
                .body(requestparams.toString());
    }

    //hit endpoint get user who currently logged in
    public void hitEndppointGetUser(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.User);
    }
    //hit endpoinPutUser who currently logged in
    public void hitEndpointPutUser(){
        SerenityRest
                .when()
                .put(endpoint.User);
    }

    //hit endpointDeleteUser who currently logged in
    public void hitEndpointDeleteUser(){
        SerenityRest
                .given()
                .header("Content-Type","application-json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete(endpoint.User);
    }
    //valdate status code endpoint
    public void validateStatusCodeEndpoint(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    //validate JSONSCHEMA Get User who currently login
    public void jsonshemaEndpointGetUser(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/User/getUser.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
    //valdate JSONSchema Put User who currently login
    public void jsonschmeEndpointPutUser(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/User/putUser.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
    //valdate JSONSchema Put User who currently login
    public void jsonschmeEndpointDeleteUser(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/User/deleteUser.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
}