package com.tricentis.demowebshop;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddToWishlistTests extends BaseTest {


    @Test
    public void addToWishlistTest() {
        String cookieValue = loginCookieValue();
        String body = "addtocart_43.EnteredQuantity=1";

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH", cookieValue)
                .body(body)
                .when()
                .post("/addproducttocart/details/43/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"));

    }

    @Test
    public void invalidAddToWishlistTest() {
        String cookieValue = loginCookieValue();
        String body = "something";

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH", cookieValue)
                .body(body)
                .when()
                .post("/addproducttocart/details/43/2")
                .then()
                .log().all()
                .statusCode(302);

    }
}

