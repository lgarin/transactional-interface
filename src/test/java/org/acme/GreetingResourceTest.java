package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    @Test
    public void testTransactionEndpoint() {
        given()
          .when().post("/create?field=test")
          .then()
             .statusCode(204);
    }
    
    @Test
    public void testDefaultTransactionEndpoint() {
        given()
          .when().post("/createDefault?field=test")
          .then()
             .statusCode(204);
    }
}