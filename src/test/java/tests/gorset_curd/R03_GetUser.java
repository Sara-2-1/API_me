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

public class R03_GetUser extends GoRestBaseUrl {
    /*
    Given
        https://gorest.co.in/public/v2/users/userId
    When
        Send the get request
    Then
        Status code should be 20o
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
    void getUserTest() {

        //Send the request
        Response response = given(spec).get("/users/" + userId);
        response.prettyPrint();

        //Do assertion
        JsonNode userBody = getJsonNode("gorest_user");
        response
                .then()
                .statusCode(200)
                .time(lessThan(3000L))
                .body(
                        "name", equalTo(userBody.get("name").asText()),
                        "gender", equalTo(userBody.get("gender").asText()),
                        "email", equalTo(randomEmail),
                        "status", equalTo(userBody.get("status").asText())
                );
    }
}
