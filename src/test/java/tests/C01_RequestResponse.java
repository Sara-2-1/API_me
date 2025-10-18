package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_RequestResponse {

    @Test
    void test01() {

        Response response = RestAssured.get("https://bookstore.demoqa.com/BookStore/v1/Books");
        //response.prettyPrint();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);

       // boolean isTimeLess = response.time() < 5000;
       // Assert.assertTrue(isTimeLess);

        Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
        Assert.assertEquals(response.header("Server"), "nginx/1.17.10 (Ubuntu)");
        Assert.assertEquals(response.header("Connection"), "keep-alive");
        Assert.assertTrue(response.contentType().contains("application/json"));

        System.out.println(response.headers());

    }

}
