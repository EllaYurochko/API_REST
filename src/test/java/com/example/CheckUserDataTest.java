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
                .auth().oauth2("введи_сюда_свой_токен")
                .get("/api/users/me")
                // напиши код для десериализации ответа в объект типа User
                .body().as(User.class);
        // выбери подходящий assert
        MatcherAssert.assertThat(user, notNullValue());
    }
}
