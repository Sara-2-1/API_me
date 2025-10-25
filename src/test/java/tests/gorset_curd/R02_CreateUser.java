package tests.gorset_curd;
import base_urls.GoRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class R02_CreateUser extends GoRestBaseUrl {
    /*
    Given
        https://gorest.co.in/public/v2/users
    And
        {
            "name":"John",
            "gender":"male",
            "email":"john.doe@gmail.com",
            "status":"active"
         }
    When
        Send the post request
    Then
        Status code should be 201
    And
        Response body should be like:
          {
            "id":321435,
            "name":"John",
            "gender":"male",
            "email":"john.doe@gmail.com",
            "status":"active"
         }

    */

    public static int userId;
    public static String randomEmail;

    @Test
    void createUserTest() {

        //Set the payload
        JsonNode payload = ObjectMapperUtils.getJsonNode("gorest_user");
        randomEmail = Math.random() + "@gmail.com";
        ((ObjectNode) payload).put("email", randomEmail);

        //Send the request
        Response response = given(spec)
                .body(payload)
                .post("/users");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(201)
                .time(lessThan(3000L))
                .body(
                        "name", equalTo(payload.get("name").asText()),
                        "email", equalTo(payload.get("email").asText()),
                        "gender", equalTo(payload.get("gender").asText()),
                        "status", equalTo(payload.get("status").asText())
                );
        userId = response.jsonPath().getInt("id");
    }
}
