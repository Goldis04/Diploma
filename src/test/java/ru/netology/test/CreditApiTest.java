package ru.netology.test;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class CreditApiTest {
    @Test
    public void testSuccessfulCredit() {
        RestAssured.baseURI = "http://localhost:9999/credit";
        given()
                .contentType("application/json")
                .body("{\"cardNumber\":\"4111111111111111\", \"amount\":1000}")
                .when()
                .post("/request")
                .then()
                .statusCode(200)
                .body("status", equalTo("approved"));
    }
