package com.example;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.auth;

public class ProfileTest {

    @Before
    public void Setup(){
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    public void updateProfile() {
        Profile profile  = new Profile("Василий Васильев", "Самый крутой исследователь"); // создай объект, который соответствует JSON
        given()
                .header("Content-type", "application/json") // заполни header
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDdjYjAxYjQzNDI0NDAwM2QyNzc2MDgiLCJpYXQiOjE2ODkwMTA4NjksImV4cCI6MTY4OTYxNTY2OX0.O8yihtJxJm8UhdE5yG0BqspJS34UZUrojaWmDHFCV8Q")
                .and()
                .body(profile) // заполни body
                .when()
                .patch("/api/users/me"); // отправь запрос на ручку
    }
}
