package Starter.Checkout;
import Starter.BaseEndpoint.baseEndpoint;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class checkoutSteps {
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
    public void setBodyRequestOVO(){
        requestparams = new JSONObject();
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(94);
        myNumbers.add(95);
        requestparams.put("booking_id", myNumbers);
        requestparams.put("phone","+628123123123");
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .body(requestparams.toString())
                .when()
                .post(endpoint.CheckoutOvo);
    }
    public void setBodyRequestOtherThanOVO(){
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(96);
        myNumbers.add(97);
        requestparams.put("booking_id", myNumbers);
        requestparams.put("checkout_method","DANA");
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .body(requestparams.toString())
                .when()
                .post(endpoint.CheckoutOtherThanOvo);
    }
    public void validateEndpointCheckout(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    public void JsonschemaEndpointCheckoutOvo(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Checkout/checkoutOvo.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
    public void JsonschemaEndpointCheckoutOtherOvo(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Checkout/checkoutOtherOvo.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
}