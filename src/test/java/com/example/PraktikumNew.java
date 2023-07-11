package com.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PraktikumNew {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }
    @Test
    public void createNewPlaceAndCheckResponse(){
        File json = new File("src/test/resources/newCard.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDdjYjAxYjQzNDI0NDAwM2QyNzc2MDgiLCJpYXQiOjE2ODkwMTA4NjksImV4cCI6MTY4OTYxNTY2OX0.O8yihtJxJm8UhdE5yG0BqspJS34UZUrojaWmDHFCV8Q")
                        .and()
                        .body(json)
                        .when()
                        .post("/api/cards");
        // проверка, что вернулся непустой ID нового места
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
    }
}