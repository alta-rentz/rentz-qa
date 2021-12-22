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
        requestparams.put("email","tanpa_nama10@gmail.com");
        requestparams.put("password","121131");
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
    //setBodyRequest untuk failed edit data user who currently logged in
    public void setBodyRequestFailedEdit(String nama, String email, String password, String phone) {
        requestparams = new JSONObject();
        requestparams.put("nama", nama);
        requestparams.put("email", email);
        requestparams.put("password", password);
        requestparams.put("phone", phone);

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
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
    public void hitEndppointFailedGetUser(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
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
    //hit endpointFailedDeleteUser who currently logged in
    public void hitEndpointFailedDeleteUser(){
        SerenityRest
                .given()
                .header("Content-Type","application-json")
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
                .body(matchesJsonSchemaInClasspath("JSONSchema/User/Sukses/getUser.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
    //validate JSONSCHEMA Failed Get User who currently login
    public void jsonshemaEndpointFailedGetUser(String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/User/Failed/getUserFailed.json"))
                .body("message",equalTo(message));
    }
    //valdate JSONSchema Put User who currently login
    public void jsonschmeEndpointPutUser(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/User/Sukses/putUser.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
    //valdate JSONSchema Failed Put User who currently login
    public void jsonschmeEndpointFailedPutUser(String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/User/Failed/putUserFailed.json"))
                .body("message",equalTo(message));
    }
    //valdate JSONSchema Delete User who currently login
    public void jsonschmeEndpointDeleteUser(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/User/Sukses/deleteUser.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
    //valdate JSONSchema Failed Delete User who currently login
    public void jsonschmeEndpointFailedDeleteUser(String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/User/Failed/deleteUserFailed.json"))
                .body("message",equalTo(message));
    }
}