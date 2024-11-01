package io.better_banking.ob_1_define_the_contract.controllers;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TransactionComponentTest {

    @LocalServerPort
    private int port;

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    void testFindAllByAccountNumberReturnTransaction() {

        String accountNumber = "111111111";

        given()
            .port(port)
        .when()
            .get("/transactions/{accountNumber}", accountNumber)
        .then()
            .statusCode(200)
            .assertThat()
            .body("$", hasSize(0));
        
    }

}
