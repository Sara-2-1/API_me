package tests.gorset_curd;

import base_urls.GoRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static tests.gorset_curd.R02_CreateUser.randomEmail;
import static tests.gorset_curd.R02_CreateUser.userId;
import static utilities.ObjectMapperUtils.getJsonNode;

public class R07_GetUserNegative extends GoRestBaseUrl {
    /*
    Given
        https://gorest.co.in/public/v2/users/userId
    When
        Send the get request
    Then
        Status code should be 404
    And
        Response body should be like:
        {
            "message": "Resource not found"
        }

    */
    @Test
    void getUserTest() {

        //Send the request
        Response response = given(spec).get("/users/" + userId);
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(404)
                .time(lessThan(3000L))
                .body("message", equalTo("Resource not found"));
    }
}
