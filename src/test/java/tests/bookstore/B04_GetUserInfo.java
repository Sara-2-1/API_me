package tests.bookstore;

import base_urls.BookstoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class B04_GetUserInfo extends BookstoreBaseUrl {

    @Test(dependsOnMethods = {"tests.bookstore.B03_AddBooks.addBooksTest"})
    void getUserInfoTest() {
        Response response = given(spec)
                .header("Authorization", "Bearer " + B02_GenerateToken.token)
                .get("/Account/v1/User/" + B01_CreateUser.userId);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("userId", equalTo(B01_CreateUser.userId))
                .body("username", equalTo(B01_CreateUser.userName));
    }
}
