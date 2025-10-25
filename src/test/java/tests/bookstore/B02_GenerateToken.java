package tests.bookstore;

import base_urls.BookstoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class B02_GenerateToken extends BookstoreBaseUrl {

    public static String token;
    @Test(dependsOnMethods = {"tests.bookstore.B01_CreateUser.createUserTest"})
    void generateTokenTest() {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode payload = mapper.createObjectNode();
        payload.put("userName", B01_CreateUser.userName);
        payload.put("password", B01_CreateUser.password);

        Response response = given(spec)
                .body(payload)
                .post("/Account/v1/GenerateToken");

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("status", equalTo("Success"))
                .body("token", notNullValue());

        token = response.jsonPath().getString("token");
        System.out.println("Generated Token: " + token);
    }
}
