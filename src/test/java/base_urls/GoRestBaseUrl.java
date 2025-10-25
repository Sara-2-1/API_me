package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class GoRestBaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setSpec() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/v2")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer ed3d823cad051cc8500d856807b8ba16c22be4a15ae63b20945d97805dcc4b9a")
                .build();
    }

}
