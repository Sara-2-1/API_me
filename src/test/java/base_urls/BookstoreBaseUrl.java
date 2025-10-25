package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BookstoreBaseUrl {
    protected RequestSpecification spec;

    public BookstoreBaseUrl() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://bookstore.demoqa.com")
                .setContentType(ContentType.JSON)
                .build();
    }
}
