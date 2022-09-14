package org.acme;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MyResourceTest {

    @Test
    public void testTransactionEndpoint() {
        given()
          .when().post("/create?field=test1")
          .then().statusCode(204);
    }
    
    @Test
    public void testDefaultTransactionEndpoint() {
        given()
          .when().post("/createDefault?field=test2")
          .then().statusCode(204);
    }
}