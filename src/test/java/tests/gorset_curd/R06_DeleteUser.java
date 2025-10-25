package tests.gorset_curd;

import base_urls.GoRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static tests.gorset_curd.R02_CreateUser.randomEmail;
import static tests.gorset_curd.R02_CreateUser.userId;
import static utilities.ObjectMapperUtils.getJsonNode;

public class R06_DeleteUser extends GoRestBaseUrl {
    /*
    Given
        https://gorest.co.in/public/v2/users/userId
    When
        Send the delete request
    Then
        Status code should be 204
    And
        Response body should be empty
    */
    @Test
    void deleteUserTest() {
        //Send the request
        Response response = given(spec).delete("/users/" + userId);
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(204)
                .time(lessThan(3000L))
                .body(emptyString());
    }
}
