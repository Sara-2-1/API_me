package tests.gorset_curd;

import base_urls.GoRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static tests.gorset_curd.R02_CreateUser.randomEmail;
import static tests.gorset_curd.R02_CreateUser.userId;
import static utilities.ObjectMapperUtils.getJsonNode;
import static utilities.ObjectMapperUtils.setJsonNode;

public class R04_UpdateUser extends GoRestBaseUrl {
    /*
    Given
        https://gorest.co.in/public/v2/users/userId
    And
        {
            "name":"John",
            "gender":"male",
            "email":"john.doe@gmail.com",
            "status":"active"
         }

    When
        Send the put request
    Then
        Status code should be 200
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
    @Test
    void updateUserTest() {

        //Set the payload
        JsonNode payload = getJsonNode("gorest_user_updated");
        randomEmail = Math.random() + "@outlook.com";
        setJsonNode(payload, "email", randomEmail);

        //Send the request
        Response response = given(spec).body(payload).put("/users/" + userId);
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200)
                .time(lessThan(3000L))
                .body(
                        "name", equalTo(payload.get("name").asText()),
                        "gender", equalTo(payload.get("gender").asText()),
                        "email", equalTo(randomEmail),
                        "status", equalTo(payload.get("status").asText())
                );

    }
}
