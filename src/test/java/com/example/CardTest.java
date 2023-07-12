package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CardTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void checkClassCard(){
        Card card = new Card("Интересное место", "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg");
        Response response =
        given()
                .header("Content-type", "application/json")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDdjYjAxYjQzNDI0NDAwM2QyNzc2MDgiLCJpYXQiOjE2ODkwMTA4NjksImV4cCI6MTY4OTYxNTY2OX0.O8yihtJxJm8UhdE5yG0BqspJS34UZUrojaWmDHFCV8Q")
                .and()
// сюда передали созданный объект с нужными значениями полей
                .body(card)
                .when()
                .post("/api/cards");
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
    }

    @Test
    public void createNewCard2() {
        for (int i = 0; i < 10; i++) {
            Card card = new Card(String.format("%s-%d", "Москва", i),
                    "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenium.jpg"); // экземпляр класса Card со значениями полей

            given()
                    .header("Content-type", "application/json") // передача Content-type в заголовке для указания типа файла
                    .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDdjYjAxYjQzNDI0NDAwM2QyNzc2MDgiLCJpYXQiOjE2ODkwMTA4NjksImV4cCI6MTY4OTYxNTY2OX0.O8yihtJxJm8UhdE5yG0BqspJS34UZUrojaWmDHFCV8Q") // передача токена для аутентификации
                    .and()
                    .body(card) // передача объекта с данными
                    .when()
                    .post("/api/cards") // отправка POST-запроса
                    .then().statusCode(201); // проверка кода ответа
        }
    }
}
