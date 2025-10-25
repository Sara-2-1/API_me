package tests.bookstore;

import base_urls.BookstoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class B03_AddBooks extends BookstoreBaseUrl {

    @Test(dependsOnMethods = {"tests.bookstore.B02_GenerateToken.generateTokenTest"})
    void addBooksTest() {
        ObjectMapper mapper = new ObjectMapper();

        //  payload
        ObjectNode payload = mapper.createObjectNode();
        payload.put("userId", B01_CreateUser.userId);

        //  add the book
        com.fasterxml.jackson.databind.node.ArrayNode booksArray = mapper.createArrayNode();
        ObjectNode book = mapper.createObjectNode();
        book.put("isbn", "9781449331818");
        booksArray.add(book);

        payload.set("collectionOfIsbns", booksArray);

        // send token
        Response response = given(spec)
                .header("Authorization", "Bearer " + B02_GenerateToken.token)
                .body(payload)
                .post("/BookStore/v1/Books");

        response.prettyPrint();

        response.then()
                .statusCode(201)
                .body("books[0].isbn", equalTo("9781449331818"));
    }
}
