package apiTests;

import base.BaseAPIs;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITests extends BaseAPIs {

    @Test
    public void APITest(){
        //Setting the endpoint
        String Endpoint = "/objects";

        //Getting the payload from the .json file
        JsonNode data = readJson("src/main/resources/Payloads.json");
        JsonNode dataNode = data.get("ValidPayload").get("data");
        Object payload = data.get("ValidPayload");

        //Making the Post request for the endpoint with the payload and saving the response
        Response response = postRequest(Endpoint,payload);

        //Logging the body in the console
        response.then().log().body();
        //Asserting that request is done successfully
        response.then().statusCode(200);
        //Asserting that id and createdAt are not empty
        softly.assertNotNull(response.path("id"));
        softly.assertNotNull(response.path("createdAt"));

        //Asserting that the data in the response are the data in tha payload
        softly.assertEquals(response.path("name").toString(),data.get("ValidPayload").get("name").asText(),
                "Wrong name!");
        softly.assertEquals(response.body().path("data.year").toString(),dataNode.get("year").asText(),
                "Wrong year!");
        softly.assertEquals(response.body().path("data.price").toString(),dataNode.get("price").asText(),
                "Wrong price!");
        softly.assertEquals(response.body().path("data['CPU model']").toString(),dataNode.get("CPU model").asText(),
                "Wrong CPU Model!");
        softly.assertEquals(response.body().path("data['Hard disk size']").toString(),dataNode.get("Hard disk size").asText(),
                "Wrong Hard Disk Size!");

        //Asserting all
        softly.assertAll();

    }
}
