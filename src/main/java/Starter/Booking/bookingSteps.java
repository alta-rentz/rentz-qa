package Starter.Booking;
import Starter.BaseEndpoint.baseEndpoint;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class bookingSteps {
    baseEndpoint endpoint = new baseEndpoint();
    JSONObject requestparams;
    String token;
//    Integer ID;

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
    public void setBodyRequestCreate(){
        requestparams = new JSONObject();
        requestparams.put("product_id",1);
        requestparams.put("time_in","2021-12-27");
        requestparams.put("time_out","2021-12-28");
        requestparams.put("qty",2);

        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .body(requestparams.toString());

//        ID = SerenityRest
//                .then()
//                .extract()
//                .path("idBook.ID");
    }
    public void setBodyRequestPersonalRental(){
        requestparams.put("product_id",14);
        requestparams.put("time_in","2021-12-26");
        requestparams.put("time_out","2021-12-27");
        requestparams.put("qty",2);

        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .body(requestparams.toString());
    }
    public void setBodyRequestSameTime(){
        requestparams.put("product_id",10);
        requestparams.put("time_in","2021-12-26");
        requestparams.put("time_out","2021-12-26");
        requestparams.put("qty",2);

        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .body(requestparams.toString());
    }
    public void setBodyRequestSearchBooking(String time_in, String time_out){
        requestparams.put("time_in",time_in);
        requestparams.put("time_out",time_out);

        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestparams.toString());
    }
    public void hitEndpointCreateBooking(){
        SerenityRest
                .when()
                .post(endpoint.CreateBooking);
    }
    public void hitEndpointSearchBooking(int ID){
        SerenityRest
                .when()
                .post(endpoint.SearchBooking+ID);
    }
    public void hitEndpointGetAllBooking(){
        SerenityRest
                .given()
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GETAllBooking);
    }
    public void hitEndpointGetBooking(int ID){
        SerenityRest
                .given()
                .header("Authorization","Bearer "+token)
                .when()
                .get(endpoint.GETBookingID+ID);
    }
    public void hitEndpointDeleteBooking(int ID){
        SerenityRest
                .given()
                .header("Authorization","Bearer "+token)
                .when()
                .delete(endpoint.DeleteBookingID+ID);
    }
    public void validateEndpointBooking(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    public void JsonschemaEndpointSuccessBooking(String message, String status){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Booking/bookingSukses.json"))
                .body("message",equalTo(message))
                .body("status",equalTo(status));
    }
    public void JsonschemaEndpointBooking(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Booking/booking.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
    public void JsonschemaEndpointGetBooking(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Booking/getBooking.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
    public void JsonschemaEndpointGetAllBooking(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Booking/getAllBooking.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
}