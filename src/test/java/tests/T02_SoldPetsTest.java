package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import base_urls.SoldPetsBaseUrl;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class T02_SoldPetsTest extends SoldPetsBaseUrl {

    @Test
    public void testSoldPets() {

        // Send GET request to fetch sold pets
        Response response = given(spec).get("/v2/pet/findByStatus?status=sold");
        response.prettyPrint();

        response.then()
                .statusCode(200)

                // Verify that the response array contains at least one item where the status field equals "sold"
                .body("status", hasItem("sold"))

                // Check that the response array contains items with specific pet names (choose any two names that exist)
                .body("name", hasItems("doggie", "Rex"))

                // Assert that at least one item in the response array has a name field that contains a specific substring
                .body("name", hasItem(containsString("og")))

                //  Confirm that the response array has a specific size (example: exactly 20 items)
                .body("size()", greaterThan(0))

                // Verify that at least one item in the response array has an id field with a value greater than a specified number
                .body("id", hasItem(greaterThan(100)))

                // Check that the response is an instance of a List/Array
                .body("", instanceOf(java.util.List.class))

                // Verify that at least one item in the response array has a name field that starts with a specific prefix
                .body("name", hasItem(startsWith("dog")))

                // Check that every item in the response array has a status field with the value "sold"
                .body("status", everyItem(equalTo("sold")))

                //  Assert that at least one item in the response array has either a specific name or a specific id value
                .body("name", anyOf(hasItem("doggie"), hasItem("Max")));
    }
}
