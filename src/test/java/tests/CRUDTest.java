package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import pojos.Activity;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static io.restassured.RestAssured.given;

public class CRUDTest {

    // إعداد الـ Base Specification
    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri("https://fakerestapi.azurewebsites.net/api/v1")
            .setContentType(ContentType.JSON)
            .build();

    @Test
    public void testCRUDOperations() {

        int activityId = 1;

        // =============== 1️⃣ CREATE (Test POST only) ===============
        Activity newActivity = new Activity();
        newActivity.setTitle("Test Automation");
        newActivity.setDueDate("2025-10-20T00:00:00");
        newActivity.setCompleted(false);

        Response postResponse = given(spec)
                .body(newActivity)
                .when()
                .post("/Activities");

        // POST في FakeRestAPI id = 0
        assertEquals(200, postResponse.statusCode());
        System.out.println("POST Response: " + postResponse.asString());

        // =============== 2️⃣ READ (GET) ===============
        Response getResponse = given(spec)
                .get("/Activities/" + activityId);

        assertEquals(200, getResponse.statusCode());
        Activity fetchedActivity = getResponse.as(Activity.class);
        System.out.println("GET Response: " + getResponse.asString());

        assertEquals(activityId, fetchedActivity.getId());
        assertEquals("Activity 1", fetchedActivity.getTitle());

        // =============== 3️⃣ UPDATE (PUT) ===============
        fetchedActivity.setTitle("Updated Title");
        fetchedActivity.setCompleted(true);

        Response putResponse = given(spec)
                .body(fetchedActivity)
                .put("/Activities/" + activityId);

        assertEquals(200, putResponse.statusCode());
        Activity updatedActivity = putResponse.as(Activity.class);
        System.out.println("PUT Response: " + putResponse.asString());

        assertTrue(updatedActivity.isCompleted());
        assertEquals("Updated Title", updatedActivity.getTitle());

        // =============== 4️⃣ DELETE (DELETE) ===============
        Response deleteResponse = given(spec)
                .delete("/Activities/" + activityId);

        assertEquals(200, deleteResponse.statusCode());
        System.out.println("DELETE Response: " + deleteResponse.asString());

        Response getDeleted = given(spec)
                .get("/Activities/" + activityId);

        assertEquals(200, getDeleted.statusCode());
        System.out.println("GET after DELETE Response: " + getDeleted.asString());

    }
}
