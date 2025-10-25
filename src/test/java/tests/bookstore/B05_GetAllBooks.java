package tests.bookstore;

import base_urls.BookstoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class B05_GetAllBooks extends BookstoreBaseUrl {

    @Test
    void getAllBooksTest() {
        Response response = given(spec)
                .get("/BookStore/v1/Books");

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("books", not(empty()));
    }
}
