package base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class BaseAPIs {
    private ObjectMapper objectMapper;
    protected SoftAssert softly;

    @BeforeClass
    public void setup() {
        // Configure RestAssured base URI
        RestAssured.baseURI = "https://api.restful-api.dev";
        softly = new SoftAssert();
    }


    protected Response postRequest(String endpoint, Object payload) {
        return given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    protected Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    protected JsonNode readJson(String path){
        objectMapper = new ObjectMapper();
        JsonNode data = null;
        try{
            data = objectMapper.readTree(new File(path));

        }catch (IOException e){
            System.out.println(e);
        }
        return data;



    }




}
