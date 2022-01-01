package Starter.Goals;
import Starter.BaseEndpoint.baseEndpoint;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class goalsSteps {
    baseEndpoint endpoint = new baseEndpoint();
    JSONObject requestparams;
    String token;
    String token_1;
    Integer ID;
    Integer ID_1;
    Integer ID_2;
    Integer ID_3;

    //hit endpoint untuk login sebagai user rental
    public void hitEndpointLoginUserRental(){
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
    //hit endpoint untuk login sebagai user booking
    public void hitEndpointLoginUserBooking(){
        requestparams = new JSONObject();
        requestparams.put("email","hassimi@alterra.com");
        requestparams.put("password","ZXcv1234");
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestparams.toString())
                .when()
                .post(endpoint.LOGIN)
                .then()
                .statusCode(200);

        token_1 = SerenityRest
                .then()
                .extract()
                .path("data.Token");
    }
    //hit endpoint create product with ovo
    public void setBodyRequestCreateProductUserRentalWithOvo(){
        SerenityRest
                .given()
                .header("Content-Type","multipart/form-data")
                .header("Authorization","Bearer "+ token)
                .multiPart("name","Dell Vostro 14 3000")
                .multiPart("subcategory_id",311)
                .multiPart("city_id",3273)
                .multiPart("price",10000)
                .multiPart("description","Laptop i3 gen 10th")
                .multiPart("stock",99)
                .multiPart("guarantee",1)
                .multiPart("photos",new File("C:/Users/ftoru/Pictures/DellVostro143405.jpg"))
                .when()
                .post(endpoint.Product);

        ID = SerenityRest
                .then()
                .extract()
                .path("product_id");
    }
    //hit endpoint create product other ovo
    public void setBodyRequestCreateProductUserRentalOtherOvo(){
        SerenityRest
                .given()
                .header("Content-Type","multipart/form-data")
                .header("Authorization","Bearer "+ token)
                .multiPart("name","Acer Aspire 14")
                .multiPart("subcategory_id",311)
                .multiPart("city_id",3273)
                .multiPart("price",10000)
                .multiPart("description","laptop i5 gen 10th")
                .multiPart("stock",99)
                .multiPart("guarantee",1)
                .multiPart("photos",new File("C:/Users/ftoru/Pictures/AcerAspireE14.jpg"))
                .when()
                .post(endpoint.Product);

        ID_1 = SerenityRest
                .then()
                .extract()
                .path("product_id");
    }
    public void setBodyRequestCreateBookingUserBookingWithOvo() {
        requestparams = new JSONObject();
        requestparams.put("product_id",ID);
        requestparams.put("time_in", "2021-12-31");
        requestparams.put("time_out", "2022-01-01");
        requestparams.put("qty", 2);

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token_1)
                .body(requestparams.toString())
                .when()
                .post(endpoint.CreateBooking);

        ID_2 = SerenityRest
                .then()
                .extract()
                .path("idBook.ID");
    }
    public void setBodyRequestCreateBookingUserBookingOtherOvo() {
        requestparams = new JSONObject();
        requestparams.put("product_id",ID_1);
        requestparams.put("time_in", "2021-12-31");
        requestparams.put("time_out", "2022-01-01");
        requestparams.put("qty", 2);

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token_1)
                .body(requestparams.toString())
                .when()
                .post(endpoint.CreateBooking);

        ID_3 = SerenityRest
                .then()
                .extract()
                .path("idBook.ID");
    }
    public void setBodyRequestOVO(){
        requestparams = new JSONObject();
        ArrayList<Integer> myNumbers = new ArrayList<Integer>(ID_2);
        myNumbers.add(ID_2);
        requestparams.put("booking_id", myNumbers);
        requestparams.put("phone","+628232327327283");
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token_1)
                .body(requestparams.toString())
                .when()
                .post(endpoint.CheckoutOvo);
    }
    public void setBodyRequestOtherOVO(){
        requestparams = new JSONObject();
        ArrayList<Integer> myNumbers = new ArrayList<Integer>(ID_3);
        myNumbers.add(ID_3);
        requestparams.put("booking_id", myNumbers);
        requestparams.put("checkout_method","ID_DANA");
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token_1)
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
