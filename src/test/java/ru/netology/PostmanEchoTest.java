package ru.netology;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldReturnPostData() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType("text/plain; charset=UTF-8")  // указываем тип контента
                .body("some data")                          // тело запроса
                .when()
                .post("/post")                              // POST-запрос
                .then()
                .statusCode(200)                            // проверка статуса
                .body("data", equalTo("WRONG_VALUE"));  // Заведомо неверное значение
    }
}