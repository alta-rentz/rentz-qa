package Starter.Product;

import Starter.BaseEndpoint.baseEndpoint;
import net.serenitybdd.rest.SerenityRest;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class getProductSteps {
    baseEndpoint endpoint = new baseEndpoint();

    //Header
    public void setHeader(String header, String content){
        SerenityRest
                .given()
                .header(header,content);
    }

    //Hit Get All Product
    public void hitEndPointGetProduct(){
        SerenityRest
                .when()
                .get(endpoint.GetAllProduct);
    }

    //Hit Get Product By Subcategory ID
    public void hitEndPointGetProductSID(int SubcategoryID){
        SerenityRest
                .when()
                .get(endpoint.GetProductSID+SubcategoryID);
    }
    //Hit Get Product By ID
    public void hitEndPointGetProductID(int ID){
        SerenityRest
                .when()
                .get(endpoint.GetProductID+ID);
    }

    //Validasi Respons Code Get Product
    public void valdateEndpointGet(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    //Validasi JsonSchema Get All Product
    public void JsonSchemaGetAllProductSuccess(int code, String message){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Product/getAllProduct.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message));
    }

    //Validasi JsonSchema By Subcategory ID
    public void JsonSchemaGetProductBySID(int code, String message, int SubcategoryID){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Product/getProductSID.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message))
                .body("data[0].SubcategoryID",equalTo(SubcategoryID));
    }

    //Validasi JsonSchema Get Product By ID
    public void JsonSchemaGetProductByID(int code, String message, int ID){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/Product/getProductID.json"))
                .body("code",equalTo(code))
                .body("message",equalTo(message))
                .body("data.ID",equalTo(ID));
    }
}