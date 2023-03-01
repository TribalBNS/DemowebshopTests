package com.tricentis.demowebshop;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }
    public String loginCookieValue() {
        String cookie;
        try {
            cookie = new String(Files.readAllBytes(Paths.get("src/test/resources/cookie.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cookie;
    }
}