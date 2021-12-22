package Starter.Product;
import Starter.BaseEndpoint.baseEndpoint;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;


public class createProductSteps {
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
    //setBodyRequest untuk create product
    public void setBodyRequest(String name,String subcategory_id,String city_id,String price,String description,String stock,String guarantee){
        SerenityRest
                .given()
                .header("Content-Type","multipart/form-data")
                .header("Authorization","Bearer "+token)
                .multiPart("name",name)
                .multiPart("subcategory_id",subcategory_id)
                .multiPart("city_id",city_id)
                .multiPart("price",price)
                .multiPart("description",description)
                .multiPart("stock",stock)
                .multiPart("guarantee",guarantee)
                .multiPart("photos",new File("C:/Users/ftoru/Downloads/unjang.png"));
    }
    public void hitEnpointCreateProduct(){
        SerenityRest
                .when()
                .post(endpoint.Product);
    }
    public void validateEndpointCreateProduct(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    public void JsonschemaEndpointCreateProduct(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Product/createProduct.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }
}