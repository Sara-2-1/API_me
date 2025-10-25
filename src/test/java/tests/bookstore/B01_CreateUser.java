package tests.bookstore;

import base_urls.BookstoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class B01_CreateUser extends BookstoreBaseUrl {

    public static String userId;
    public static String userName = "User" + System.currentTimeMillis();
    public static String password = "Password@123";

    @Test
    void createUserTest() {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode payload = mapper.createObjectNode();
        payload.put("userName", userName);
        payload.put("password", password);

        Response response = given(spec)
                .body(payload)
                .post("/Account/v1/User");

        response.prettyPrint();

        response.then()
                .statusCode(201)
                .body("username", equalTo(userName));

        userId = response.jsonPath().getString("userID");
        System.out.println("Created userID: " + userId);
        System.out.println("Created userName: " + userName);
    }
}
