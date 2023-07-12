package com.example;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.hamcrest.MatcherAssert;

public class CheckUserDataTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void checkUserName() {
        User user = given()
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDdjYjAxYjQzNDI0NDAwM2QyNzc2MDgiLCJpYXQiOjE2ODkwMTA4NjksImV4cCI6MTY4OTYxNTY2OX0.O8yihtJxJm8UhdE5yG0BqspJS34UZUrojaWmDHFCV8Q")
                .get("/api/users/me")
                // напиши код для десериализации ответа в объект типа User
                .body().as(User.class);
        // выбери подходящий assert
        MatcherAssert.assertThat(user, notNullValue());
    }
}
