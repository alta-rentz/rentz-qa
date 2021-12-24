package Starter.Product;
import Starter.BaseEndpoint.baseEndpoint;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class deleteProductSteps {
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
    //Hit Delete Product By ID
    public void hitEndPointdeleteProductID(int ID){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete(endpoint.DeleteProduct+ID);
    }
    //Validasi Respons Code Get Product
    public void valdateEndpointGet(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    //Validasi JsonSchema Get All Product
    public void JsonSchemaDeleteProduct(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Product/deleteProduct.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
}
